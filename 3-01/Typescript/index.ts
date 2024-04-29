/**
* This is the reverse string recursion program.
*
* By:      Evan Beaudoin
* Version: 1.0
* Since:   2024-04-23
*/ 

// Function to reverse a string using recursion
function reverseString(string_to_reverse: string): string {
    if (string_to_reverse === "") {
        return "";
    } else {
        let first_character_of_string: string = string_to_reverse.charAt(0)
        let rest_of_string: string = string_to_reverse.substring(1)

        return reverseString(rest_of_string) + first_character_of_string
    }
}

// Test the function
let word: string = "recursion";
let reversedString: string = reverseString(word);

console.log(`Original String: ${word}`);
console.log(`Reversed String: ${reversedString}`);

