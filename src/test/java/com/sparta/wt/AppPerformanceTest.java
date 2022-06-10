package com.sparta.wt;

import com.sparta.wt.controller.SortManager;
import com.sparta.wt.model.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppPerformanceTest {
    private static Random randomNumGen = new Random();
    private static int[] array = new int[500];
    private static int[] sortedArray = new int[500];
    private static final Logger logger = LogConfiguration.getLogger();

    static void setup() {
        logger.setLevel(Level.OFF);
        for (int i = 0; i < array.length; i++) {
            array[i] = randomNumGen.nextInt(1_000);
        }
    }

    public static void main(String[] args) {
        setup();
        perfTest(SortManager.getSortMethod("1"));
        perfTest(SortManager.getSortMethod("2"));
        perfTest(SortManager.getSortMethod("3"));
        perfTest(SortManager.getSortMethod("4"));
    }

    static void perfTest(Sorter sortAlgorithm) {
        System.out.println("----------\nSort method: " + sortAlgorithm);
        System.out.println("Current array:\n" + Arrays.toString(array));
        sortedArray = sortAlgorithm.sortArray(array);
        double sortTime = sortAlgorithm.getTimeTaken();
        System.out.println("Sorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken to complete sort: " + sortTime / 1_000_000 + "ms");
    }

}
