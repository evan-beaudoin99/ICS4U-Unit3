/*
* This program uses a method to find a number in a long list.
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-04-22
*/

import { createPrompt } from 'bun-promptx'

// Finds the index of a number in a list.
function binarySearch(userList: number[], userNumber: number, lowIndex: number, highIndex: number): number {
  const middleIndex = Math.floor((lowIndex + highIndex) / 2)

  if (lowIndex > highIndex) {
    return -1
  } else if (userList[middleIndex] == userNumber) {
    return middleIndex
  } else if (userList[middleIndex] > userNumber) {
    return binarySearch(userList, userNumber, lowIndex, middleIndex - 1)
  } else if (userList[middleIndex] < userNumber) {
    return binarySearch(userList, userNumber, middleIndex + 1, highIndex)
  }
}

// List values
const minValue: number = 0
const maxValue: number = 999
const listSize: number = 250

// Create list
const randomNumberList: number[] = []
for (let counter = 0; counter < listSize; counter ++) {
  randomNumberList[counter] = Math.floor(Math.random() * maxValue) + minValue
}

// Sort list
// If the comparison function returns a negative value, a comes before b in the sorted array.
// If the comparison function returns a positive value, b comes before a in the sorted array.
// If the comparison function returns 0, the order of a and b remains unchanged in the sorted array.
randomNumberList.sort((a, b) => a - b)
console.log(`Sorted list of numbers:\n${randomNumberList}`)

// User input
const selectedNumberString = prompt(`\nWhat number are you searching for in the array`)
const selectedNumber: number = parseInt(selectedNumberString)

if (isNaN(selectedNumber) || selectedNumber > maxValue || selectedNumber < minValue) {
  console.log('This is not a valid number.')
} else {
  const searchResult = binarySearch(randomNumberList, selectedNumber, 0, randomNumberList.length - 1)
  if (searchResult == -1) {
    console.log(`${selectedNumber} was not found.`)
  } else {
    console.log(`${randomNumberList[searchResult]} is in index ${searchResult}`)
  }
}

console.log('\nDone.')
