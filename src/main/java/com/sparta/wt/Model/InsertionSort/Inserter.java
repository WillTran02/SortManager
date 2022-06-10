package com.sparta.wt.Model.InsertionSort;

import com.sparta.wt.Model.Sorter;

public class Inserter implements Sorter {

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
        startTime = System.nanoTime();
        int[] sortedArray = new int[array.length];
        sortedArray[0] = array[0]; //Assign the first value of the unsorted array to the first value of the sorted array
        for (int i = 1; i < array.length; i++) { //For every number in the unsorted array, minus the first
            for (int j = 0; j < sortedArray.length; j++) { //For every number in the sorted array
                if (j >= i || array[i] < sortedArray[j]) { //Compare unsorted to sorted array
                    shiftNumbersForwardOneInArrayFromIndex(sortedArray, j);
                    sortedArray[j] = array[i];
                    break;
                }
            }
        }
        timeTaken = System.nanoTime() - startTime;
        return sortedArray;
    }

    private void shiftNumbersForwardOneInArrayFromIndex(int[] array, int index) {
        if (index+1 >= array.length) return;
        shiftNumbersForwardOneInArrayFromIndex(array, index+1); //Recursive shift all numbers in array forwards
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }

}
