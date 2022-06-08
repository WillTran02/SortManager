package com.sparta.wt.Model.MergeSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeTest {

    int[] blankArray = new int[0];
    int[] filledArray = {1, 2, 3};
    int[] filledArray2 = {4, 5, 6, 7, 8};
    int[] filledMergedArray = {1, 1, 2, 2, 3, 3};
    int[] filledMergedArray2 = {1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    @DisplayName("check: entering blank arrays returns a blank array")
    void checkReturnsSingleArray() {
        Assertions.assertArrayEquals(blankArray, Merge.mergeArrays(blankArray, blankArray));
    }

    @Test
    @DisplayName("check: entering one filled and one blank array returns filled array")
    void checkOneEmptyArray() {
        Assertions.assertArrayEquals(filledArray, Merge.mergeArrays(blankArray, filledArray));
        Assertions.assertArrayEquals(filledArray, Merge.mergeArrays(filledArray, blankArray));
    }

    @Test
    @DisplayName("check: entering two filled arrays returns one merged array")
    void checkReturnsMergedArray() {
        Assertions.assertArrayEquals(filledMergedArray, Merge.mergeArrays(filledArray, filledArray));
    }

    @Test
    @DisplayName("check: entering null returns an empty array")
    void checkReturnsBlankArrayWhenNull() {
        Assertions.assertArrayEquals(blankArray, Merge.mergeArrays(null, null));
    }

    @Test
    @DisplayName("check: entering one filled array and null returns the filled array")
    void checkReturnsOneArrayWhenNull() {
        Assertions.assertArrayEquals(filledArray, Merge.mergeArrays(filledArray, null));
        Assertions.assertArrayEquals(filledArray, Merge.mergeArrays(null, filledArray));
    }

    @Test
    @DisplayName("check: entering two filled arrays of different sizes returns one merged, sorted array")
    void checkReturnsMergedSortedArray() {
        Assertions.assertArrayEquals(filledMergedArray2, Merge.mergeArrays(filledArray, filledArray2));
    }

    @Test
    @DisplayName("check: mergeSort sorts an array using mergeArrays")
    void checkSorting() {
        int[] array = new int[]{15, 62, 84, 26, 45};
        Assertions.assertArrayEquals(new int[]{15, 26, 45, 62, 84}, Merge.mergeSort(array));
    }

    @Test
    @DisplayName("check: mergeSort returns already sorted array")
    void checkAlreadySorted() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(array, Merge.mergeSort(array));
    }

    @Test
    @DisplayName("check: mergeSort returns empty array if passed an empty array")
    void checkEmpty() {
        int[] array = new int[]{};
        Assertions.assertEquals(array, Merge.mergeSort(array));
    }

}
