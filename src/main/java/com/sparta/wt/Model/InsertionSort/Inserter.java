package com.sparta.wt.Model.InsertionSort;

import com.sparta.wt.LogConfiguration;
import com.sparta.wt.Model.Sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inserter implements Sorter {

    private static final Logger logger = LogConfiguration.getLogger();
    private static double startTime;
    private static double timeTaken;

    @Override
    public String toString() { return "InsertionSort"; }

    @Override
    public int[] sortArray(int[] array) {
        return insertionSort(array);
    }

    @Override
    public double getTimeTaken() {
        return timeTaken;
    }

    private int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) return array;
        logger.log(Level.INFO, "--- InsertionSort started ---\nNow sorting array:\n" + Arrays.toString(array));
        startTime = System.nanoTime();
        int[] sortedArray = new int[array.length];
        sortedArray[0] = array[0]; //Assign the first value of the unsorted array to the first value of the sorted array
        logger.log(Level.INFO, "Got first element of array: " + sortedArray[0]);
        for (int i = 1; i < array.length; i++) { //For every number in the unsorted array, minus the first
            logger.log(Level.INFO, "Trying to insert: " + array[i]);
            for (int j = 0; j < sortedArray.length; j++) { //For every number in the sorted array
                if (j >= i || array[i] < sortedArray[j]) { //Compare unsorted to sorted array
                    logger.log(Level.INFO, "Inserting at index " + j + " on the sorted array");
                    shiftNumbersForwardOneInArrayFromIndex(sortedArray, j);
                    sortedArray[j] = array[i];
                    logger.log(Level.INFO, "" + sortedArray[j] + " has been inserted. Current sorted array:\n" + Arrays.toString(sortedArray));
                    break;
                }
            }
        }
        timeTaken = System.nanoTime() - startTime;
        logger.log(Level.INFO, "Sorting completed, returning:\n" + Arrays.toString(sortedArray));
        return sortedArray;
    }

    private void shiftNumbersForwardOneInArrayFromIndex(int[] array, int index) {
        if (index+1 >= array.length) return;
        shiftNumbersForwardOneInArrayFromIndex(array, index+1); //Recursive shift all numbers in array forwards
        logger.log(Level.INFO, "Now shifting " + array[index] + " to the right...");
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }

}
