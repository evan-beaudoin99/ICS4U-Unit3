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
    * @throws IllegalStateExceptioni if called
    *
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
        // process
        final int returnValue;

        if (userNumber == 0) {
            returnValue = 1;
        } else if (userNumber < 0) {
            returnValue = -1;
        } else {
            returnValue = userNumber * factorialCalculation(userNumber - 1);
        }
        return returnValue;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        try {
            // input & output
            final Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a number: ");
            final float roundedValue = userInput.nextFloat();
            final int numberInput = Math.round(roundedValue);
            System.out.print(factorialCalculation(numberInput));
        }
        catch (IllegalArgumentException ex) {
            System.out.println("That is an invalid input.");
        }
        System.out.println("\nDone.");
        
    }
}
