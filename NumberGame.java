import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_NUMBER = 100; // Maximum number to guess
        final int MAX_TRIES = 5; // Maximum number of tries allowed
        int secretNumber; // To store the secret number
        int guess; // To store user's guess
        int attempts; // To store number of attempts
        int roundsWon = 0; // To store number of rounds won
        boolean playAgain = true; // Flag to control playing again

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            secretNumber = (int) (Math.random() * MAX_NUMBER) + 1; // Generate a random number
            attempts = 0;

            System.out.println("\nI've selected a number between 1 and " + MAX_NUMBER + ". Can you guess it?");
            
            while (true) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the number (" + secretNumber + ") in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == MAX_TRIES) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }

        System.out.println("Thank you for playing! You won " + roundsWon + " round(s).");
    }
}
