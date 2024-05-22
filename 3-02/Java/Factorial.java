/*
* This is the factorial program
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-04-28
*/

import java.util.Scanner;

/**
 * This program calculates a factorial.
 */
final class Factorial {
    /**
     * Prevent instantiation
     * Throw an exception IllegalStateException.
     * if this ever is called
     *
     * @throws IllegalStateException if called
     */
    private Factorial() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Calculates the factorial of a number.
     *
     * @param userNumber userNumber
     * @return return factorialNumber
     */
    public static int factorialCalculation(final int userNumber) {
        // Handle edge cases
        if (userNumber < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        } else if (userNumber == 0) {
            return 1;
        } else {
            // Calculate factorial using recursion
            return userNumber * factorialCalculation(userNumber - 1);
        }
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        try {
            // input & output
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int numberInput = userInput.nextInt();

            // Calculate factorial
            int result = factorialCalculation(numberInput);

            // Print the result
            System.out.println(result);
        
        } catch (IllegalArgumentException ex) {
            System.out.println("That is an invalid input.");
        } finally {
            System.out.println("\nDone.");
        }
    }
}

