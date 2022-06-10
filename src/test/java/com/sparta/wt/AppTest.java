package com.sparta.wt;

import com.sparta.wt.Model.InsertionSort.Inserter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sparta.wt.Controller.SortManager;
import com.sparta.wt.Model.BinarySearch.TreeSort;
import com.sparta.wt.Model.BubbleSort.Bubble;
import com.sparta.wt.Model.MergeSort.Merge;

import java.util.Arrays;
import java.util.logging.Level;

public class AppTest {
    static int[] unsortedArray = new int[] {9, 1, 4, 6, 2, 7, 8, 3, 5, 0};
    static int[] sortedArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @BeforeAll
    static void setup() {
        LogConfiguration.getLogger().setLevel(Level.OFF);
    }
    @Test
    @DisplayName("check SortManager: getSortMethod(1) returns Bubble")
    void checkBubble() {
        Assertions.assertSame(SortManager.getSortMethod("1").getClass(), Bubble.class);
     }

    @Test
    @DisplayName("check SortManager: getSortMethod(2) returns Merge")
    void checkMerge() {
        Assertions.assertSame(SortManager.getSortMethod("2").getClass(), Merge.class);
    }

    @Test
    @DisplayName("check SortManager: getSortMethod(3) returns Tree")
    void checkTree() {
        Assertions.assertSame(SortManager.getSortMethod("3").getClass(), TreeSort.class);
    }
    @Test
    @DisplayName("check SortManager: getSortMethod(4) returns Inserter")
    void checkInsert() { Assertions.assertSame(SortManager.getSortMethod("4").getClass(), Inserter.class); }

    @Test
    @DisplayName("check SortManager: getArraySize(100) returns int 100")
    void checkArraySize() {
        Assertions.assertEquals(100, SortManager.getArraySize("100"));
    }

    @Test
    @DisplayName("check SortManager: sort array using interface method")
    void checkSortingFunctionality() {
        System.out.println("Unsorted Array:\n" + Arrays.toString(unsortedArray));
        Assertions.assertArrayEquals(sortedArray, SortManager.getSortMethod("1").sortArray(unsortedArray));
        System.out.println("Array sorted via " + SortManager.getSortMethod("1") + ":\n" + Arrays.toString(SortManager.getSortMethod("1").sortArray(unsortedArray)));
        Assertions.assertArrayEquals(sortedArray, SortManager.getSortMethod("2").sortArray(unsortedArray));
        System.out.println("Array sorted via " + SortManager.getSortMethod("2") + ":\n" + Arrays.toString(SortManager.getSortMethod("2").sortArray(unsortedArray)));
        Assertions.assertArrayEquals(sortedArray, SortManager.getSortMethod("3").sortArray(unsortedArray));
        System.out.println("Array sorted via " + SortManager.getSortMethod("3") + ":\n" + Arrays.toString(SortManager.getSortMethod("3").sortArray(unsortedArray)));
        Assertions.assertArrayEquals(sortedArray, SortManager.getSortMethod("4").sortArray(unsortedArray));
        System.out.println("Array sorted via " + SortManager.getSortMethod("4") + ":\n" + Arrays.toString(SortManager.getSortMethod("4").sortArray(unsortedArray)));
    }

}
