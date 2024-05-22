/**
* This uses the merge sort algorithm to sort a list of numbers.
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-05-22
*/ 

import java.util.Arrays;

/**
 * A class that implements the merge sort algorithm.
 */
final class MergeSort {

    /**
     * Sorts the input array using the merge sort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int middleIndex = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middleIndex);
        int[] rightHalf = Arrays.copyOfRange(array, middleIndex, array.length);

        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    /**
     * Merges two sorted arrays into one sorted array.
     *
     * @param leftArray  the first sorted array
     * @param rightArray the second sorted array
     * @return the merged and sorted array
     */
    public static int[] merge(int[] leftArray, int[] rightArray) {
        int[] sortedArray = new int[leftArray.length + rightArray.length];
        int leftIndex = 0, rightIndex = 0, sortedIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                sortedArray[sortedIndex++] = leftArray[leftIndex++];
            } else {
                sortedArray[sortedIndex++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArray.length) {
            sortedArray[sortedIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightArray.length) {
            sortedArray[sortedIndex++] = rightArray[rightIndex++];
        }

        return sortedArray;
    }

    /**
     * Main method to test the merge sort algorithm with different test cases.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] testArray1 = {34, 7, 23, 32, 5, 62};
        int[] testArray2 = {10, -1, 2, 5, 0, 6, 4, -5};
        int[] testArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Sorting the test cases
        int[] sortedArray1 = mergeSort(testArray1);
        int[] sortedArray2 = mergeSort(testArray2);
        int[] sortedArray3 = mergeSort(testArray3);

        // Outputting the results
        System.out.println("Sorted Array 1: " + Arrays.toString(sortedArray1));
        System.out.println("Sorted Array 2: " + Arrays.toString(sortedArray2));
        System.out.println("Sorted Array 3: " + Arrays.toString(sortedArray3));
    }
}

