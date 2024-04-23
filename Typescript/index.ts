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
        return reverseString(string_to_reverse.substr(1)) + str.charAt(0);
    }
}

// Test the function`

let str: string = "Hello, World!";
let reversedStr: string = reverseString(str);

console.log(`Original String: ${str}`);
console.log(`Reversed String: ${reversedStr}`);

