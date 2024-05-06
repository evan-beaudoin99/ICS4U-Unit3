/**
 * This program calculates factorials
 *
 * By: Evan Beaudoin
 * Version: 2.0
 * Since:   2024-03-04
 */

import { createPrompt } from 'bun-promptx'

function factorial (input: number): number {
  if (input < 0) {
    return -1
  }
  if (input === 0) {
    return 1
  } else {
    return input * factorial(input - 1)
  }
} 

let input_string = createPrompt("Enter a number you want to factorialize: ")
let input = parseFloat(input_string.value || "-1")

if (isNaN(input)) {
  console.log("Invalid input")
}
else {
  console.log(factorial(input))
}


