package com.sparta.wt.Model.MergeSort;

import com.sparta.wt.LogConfiguration;
import com.sparta.wt.Model.Sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Merge implements Sorter {

    private static final Logger logger = Logger.getLogger("MergeLogger");

    public static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        logger.log(Level.INFO, "mergeSort start:");
        int middleIndex = array.length / 2;
        int remainder = array.length % 2;
        int[] left = new int[middleIndex];
        int[] right = new int[middleIndex + remainder];
        for (int i = 0; i < middleIndex; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < middleIndex + remainder; i++) {
            right[i] = array[i + middleIndex];
        }
        logger.log(Level.INFO, "Got left: " + Arrays.toString(left));
        logger.log(Level.INFO, "Got right: " + Arrays.toString(right));
        left = mergeSort(left);
        right = mergeSort(right);
        return mergeArrays(left, right);
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
        //if both are null, return an empty array
        if (array1 == null && array2 == null) return new int[]{};
        //if one is null or empty and the other is not, return the other
        if (array1 == null || array1.length == 0) return array2;
        if (array2 == null || array2.length == 0) return array1;
        logger.log(Level.INFO, "Now merging: " + Arrays.toString(array1) + " with " + Arrays.toString(array2));
        int indexPointer1 = 0;
        int indexPointer2 = 0;
        //create an int[] of total length of the two arrays, ready to return
        int[] merged = new int[(array1.length + array2.length)];
        for (int i = 0; i < merged.length; i++) {
            //check if both arrays have been completed, if so then stop to avoid ArrayIndexOutOfBoundsExceptions
            if (indexPointer1 == array1.length && indexPointer2 == array2.length) break;
            if (indexPointer1 == array1.length) { //check if array1 has finished, if so then use array2 value
                merged[i] = array2[indexPointer2++];
                logger.log(Level.INFO, "array1 has finished, adding from array2: " + merged[i]);
            } else if (indexPointer2 == array2.length) { //check if array2 has finished, if so then use array1 value
                merged[i] = array1[indexPointer1++];
                logger.log(Level.INFO, "array2 has finished, adding from array1: " + merged[i]);
            } else //if neither array has finished, add the lower of the two values
            merged[i] = array1[indexPointer1] < array2[indexPointer2] ? array1[indexPointer1++] : array2[indexPointer2++];
            logger.log(Level.INFO, "Adding: " + merged[i]);
        }
        logger.log(Level.INFO, "Returning merged: " + Arrays.toString(merged));
        return merged;
    }

    @Override
    public int[] sortArray(int[] array) {
        com.sparta.wt.LogConfiguration.setLogConfiguration(logger, "src/main/java/com/sparta/wt/Model/MergeSort/MergeLog.log");
        logger.setLevel(Level.OFF);
        return mergeSort(array);
    }

    @Override
    public String toString() {return "MergeSort";}
}
