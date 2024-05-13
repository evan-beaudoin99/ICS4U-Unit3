/*
* This program uses a method to find where disks should be placed.
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-04-24
*/

import { createPrompt } from 'bun-promptx'

/**
 * Calculates where disks should be placed.
 *
 * @param numberOfDisks the number of disks
 * @param startPeg the starting number of pegs
 * @param endPeg the ending number of pegs
 */
function hanoi(numberOfDisks: number, startPeg: number, endPeg: number): number {
  if (numberOfDisks == 1) {
    console.log(`Move disk ${numberOfDisks} from peg ${startPeg} to ${endPeg}`)
  } else {
    hanoi(numberOfDisks - 1, startPeg, 6 - startPeg - endPeg)
    console.log(`Move disk ${numberOfDisks} from peg ${startPeg} to ${endPeg}`)
    hanoi(numberOfDisks -1, 6 - startPeg - endPeg, endPeg)
  }
}

// Peg constants
const startPeg: number = 1
const endPeg: number = 3

// User input
const selectedNumber: number = createPrompt('How many disks do you want? ').value

if (isNaN(selectedNumber) || selectedNumber < 0) {
  console.log('This is not a valid number.')
} else {
  hanoi(selectedNumber, startPeg, endPeg)
}

console.log('\nDone.')
