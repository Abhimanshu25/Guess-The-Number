import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static final int MAX_ATTEMPTS = 7;
    static final int RANGE_START = 1;
    static final int RANGE_END = 100;

    public static void main(String[] args) {
        int rounds, totalScore = 0;

        System.out.println(" Welcome to the Guess The Number Game!");
        System.out.print("Enter number of rounds you want to play: ");
        rounds = sc.nextInt();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\n Round " + round + " of " + rounds);
            int score = playRound();
            totalScore += score;
            System.out.println("Your score for this round: " + score);
        }

        System.out.println("\n Game Over!");
        System.out.println(" Total Score: " + totalScore + " out of " + (rounds * 100));
    }

    static int playRound() {
        int target = rand.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
        int attempts = 0;
        int guess;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (" + RANGE_START + "-" + RANGE_END + "): ");
            guess = sc.nextInt();
            attempts++;

            if (guess == target) {
                System.out.println(" Correct! You guessed the number in " + attempts + " attempt(s).");
                return calculateScore(attempts);
            } else if (guess < target) {
                System.out.println(" Too low!");
            } else {
                System.out.println(" Too high!");
            }
        }

        System.out.println("❌ Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The number was: " + target);
        return 0;
    }

    static int calculateScore(int attempts) {
        // Scoring: 1st try = 100, 2nd = 90, ..., 10th+ = 10
        return Math.max(100 - (attempts - 1) * 10, 10);
    }
}
