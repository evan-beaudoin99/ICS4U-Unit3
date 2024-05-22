/**
 * This program calculates factorials
 *
 * By: Evan Beaudoin
 * Version: 2.0
 * Since:   2024-05-22
 */

function mergeSort(unsortedArray: number[]): number[] {
    if (unsortedArray.length <= 1) {
        return unsortedArray
    }

    const middleIndex = Math.floor(unsortedArray.length / 2)
    const leftHalf = unsortedArray.slice(0, middleIndex)
    const rightHalf = unsortedArray.slice(middleIndex)

    return merge(mergeSort(leftHalf), mergeSort(rightHalf))
}

function merge(leftArray: number[], rightArray: number[]): number[] {
    let sortedArray: number[] = []
    let leftIndex = 0
    let rightIndex = 0

    while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
            sortedArray.push(leftArray[leftIndex])
            leftIndex++
        } else {
            sortedArray.push(rightArray[rightIndex])
            rightIndex++
        }
    }

    return sortedArray.concat(leftArray.slice(leftIndex)).concat(rightArray.slice(rightIndex))
}

// Test cases
const testArray1 = [34, 7, 23, 32, 5, 62]
const testArray2 = [10, -1, 2, 5, 0, 6, 4, -5]
const testArray3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

// Sorting the test cases
const sortedArray1 = mergeSort(testArray1)
const sortedArray2 = mergeSort(testArray2)
const sortedArray3 = mergeSort(testArray3)

// Outputting the results
console.log("Sorted Array 1:", sortedArray1) // Output: [5, 7, 23, 32, 34, 62]
console.log("Sorted Array 2:", sortedArray2) // Output: [-5, -1, 0, 2, 4, 5, 6, 10]
console.log("Sorted Array 3:", sortedArray3) // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

