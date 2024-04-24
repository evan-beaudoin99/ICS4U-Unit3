/*
* This is the reverse string recursion program.
*
* By:      Evan Beaudoin
* Version: 1.0
* Since:   2024-04-23
*/

/**
* This is the reverse string program.
*/
final class Reverse {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private Reverse() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * This function reverses a string.
    *
    * @param stringToReverse.
    * @return returnValue
    */
    public static String reverseString(String stringToReverse) {
        public String returnValue;
        if (stringToReverse.isEmpty()) {
            returnValue = "";
        } else {
            final char firstCharacterOfString = stringToReverse.charAt(0);
            final String restOfString = stringToReverse.substring(1);
            returnValue = reverseString(restOfString) 
              + firstCharacterOfString;
        }
        return returnValue;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {
        final String word = "recursion";
        final String reversedString = reverseString(word);

        System.out.println("Original String: " + word);
        System.out.println("Reversed String: " + reversedString);
    }
}

