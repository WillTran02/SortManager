package com.sparta.wt;

import com.sparta.wt.Model.MergeSort.Merge;
import com.sparta.wt.Model.BubbleSort.Bubble;
import com.sparta.wt.Model.BinarySearch.TreeSort;

import java.util.Arrays;
import java.util.Random;

public class AppPerformanceTest {
    private static Merge mergeSorter = new Merge();
    private static Bubble bubbleSorter = new Bubble();
    private static TreeSort treeSorter = new TreeSort();
    private static Random randomNumGen = new Random();
    private static int[] array = new int[200];
    private static int[] sortedArray = new int[200];

    static void setup() {
        for (int i = 0; i < array.length; i++) {
            array[i] = randomNumGen.nextInt(1000);
        }
    }

    public static void main(String[] args) {
        setup();
        bubbleSortPerfTest();
        mergeSortPerfTest();
        treeSortPerfTest();
    }

    static void bubbleSortPerfTest() {
        System.out.println("----------\nSort method: " + bubbleSorter);
        System.out.println("Current array:\n" + Arrays.toString(array));
        double startTime = System.nanoTime();
        sortedArray = bubbleSorter.sortArray(array);
        double finishTime = System.nanoTime();
        double sortTime = finishTime - startTime;
        System.out.println("Sorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken to complete sort: " + (int)(sortTime / 1_000_000) + "ns");
    }

    static void mergeSortPerfTest() {
        System.out.println("----------\nSort method: " + mergeSorter);
        System.out.println("Current array:\n" + Arrays.toString(array));
        double startTime = System.nanoTime();
        sortedArray = mergeSorter.sortArray(array);
        double finishTime = System.nanoTime();
        double sortTime = finishTime - startTime;
        System.out.println("Sorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken to complete sort: " + (int)(sortTime / 1_000_000) + "ns");
    }

    static void treeSortPerfTest() {
        System.out.println("----------\nSort method: " + treeSorter);
        System.out.println("Current array:\n" + Arrays.toString(array));
        double startTime = System.nanoTime();
        sortedArray = treeSorter.sortArray(array);
        double finishTime = System.nanoTime();
        double sortTime = finishTime - startTime;
        System.out.println("Sorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken to complete sort: " + (int)(sortTime / 1_000_000) + "ns");
    }

}
