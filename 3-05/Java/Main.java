/**
* This is the Magic Square program
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-05-12
*/ 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A program to generate unique magic squares of size 3x3.
 */
final class Main {
  /**
  * Letters i and j are variables representing the row and column of the square, 
  * similarly how in R^2 planes they presentent the x and y-axis respectively. 
  * In this program I also used matrices to represent the squares as they are much more efficient.
  */
  
    private static final int SIZE = 3; // Size of the magic square (3x3)
    private static final int MAGIC_CONSTANT = 15; // Sum of numbers from 1 to 9 for 3x3 matrix

  /**
  * Prevent instantiation.
  * Throw an exception IllegalStateException.
  * if this is ever called
  *
  * @throws IllegalStateException if this is ever called
  *
  */
  private Main() {
      throw new IllegalStateException("Cannot be instantiated");
  }


    /**
     * Generates a random magic square of size 3x3.
     *
     * @return A 2D array representing the generated magic square.
     */
    private static int[][] generateMagicSquare() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= SIZE * SIZE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); //Built-in function that shuffles the numbers 1-9

        int[][] square = new int[SIZE][SIZE];
        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = numbers.get(index++); // Add the numbers to the square
            }
        }
        return square;
    }

    /**
     * Checks if the given 2D array represents a magic square.
     *
     * @param square The 2D array to check.
     * @return True if the given array is a magic square, false otherwise.
     */
    private static boolean isMagicSquare(int[][] square) {
        // Check rows and columns sums
        for (int i = 0; i < SIZE; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < SIZE; j++) {
                rowSum += square[i][j];
                columnSum += square[j][i];
            }
            if (rowSum != MAGIC_CONSTANT || columnSum != MAGIC_CONSTANT) {
                return false;
            }
        }

        // Check diagonal sums
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        for (int i = 0; i < SIZE; i++) {
            diagonal1Sum += square[i][i];
            diagonal2Sum += square[i][SIZE - 1 - i];
        }
        return diagonal1Sum == MAGIC_CONSTANT && diagonal2Sum == MAGIC_CONSTANT;
    }

    /**
     * Checks if the list of generated magic squares contains the given magic square.
     *
     * @param squares The list of generated magic squares.
     * @param square  The magic square to check.
     * @return True if the list contains the given magic square, false otherwise.
     */
    private static boolean containsMagicSquare(List<int[][]> squares, int[][] square) {
        for (int[][] testSquare : squares) {
            if (areSquaresEqual(testSquare, square)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if two magic squares are equal.
     *
     * @param square1 The first magic square.
     * @param square2 The second magic square.
     * @return True if the two squares are equal, false otherwise.
     */
    private static boolean areSquaresEqual(int[][] square1, int[][] square2) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (square1[i][j] != square2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Prints the given magic square along with its index.
     *
     * @param square The magic square to print.
     * @param count  The index of the magic square.
     */
    private static void printMagicSquare(int[][] square, int count) {
        System.out.println("Magic Square " + count + ":");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

  /**
   * Main method to generate and print unique magic squares.
   *
   * @param args The command line arguments (unused).
   */
  public static void main(String[] args) {
      int magicSquareCount = 8; // Number of magic squares to generate
      List<int[][]> generatedMagicSquares = new ArrayList<>();

      // Loop to generate magic squares
      for (int count = 0; count < magicSquareCount; count++) {
          while (true) {
              int[][] square = generateMagicSquare();
              if (isMagicSquare(square) && !containsMagicSquare(generatedMagicSquares, square)) {
                  printMagicSquare(square, count + 1);
                  generatedMagicSquares.add(square);
                  break;
              }
          }
      }
  }
}
