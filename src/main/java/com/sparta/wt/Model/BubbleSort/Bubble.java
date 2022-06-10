package com.sparta.wt.Model.BubbleSort;

import com.sparta.wt.LogConfiguration;
import com.sparta.wt.Model.Sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bubble implements Sorter {

    private static final Logger logger = LogConfiguration.getLogger();
    private static double startTime;
    private static double finishTime;

    public static int[] bubbleSort(int[] numbers) {
        logger.log(Level.INFO, "bubbleSort method initiated");
        int[] sortedNumbers = numbers.clone();
        logger.log(Level.INFO, "Current array: " + Arrays.toString(sortedNumbers));
        startTime = System.nanoTime();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < sortedNumbers.length; i++) {
                logger.log(Level.INFO, "for loop: iteration " + i + ", comparing: " + sortedNumbers[i - 1] + " and " + sortedNumbers[i] + "...");
                if (sortedNumbers[i - 1] > sortedNumbers[i]) {
                    logger.log(Level.INFO, "swapping: " + sortedNumbers[i - 1] + " with " + sortedNumbers[i] + "...");
                    swapped = true;
                    int temp = sortedNumbers[i - 1];
                    sortedNumbers[i - 1] = sortedNumbers[i];
                    sortedNumbers[i] = temp;
                }
            }
            logger.log(Level.INFO, "Did a swap occur? " + swapped);
            logger.log(Level.INFO, swapped ? "repeating..." : "finishing...");
        } while(swapped);
        finishTime = System.nanoTime();
        logger.log(Level.INFO, "Finalized array: " + Arrays.toString(sortedNumbers));
        logger.log(Level.INFO, "exiting bubbleSort method.");
        return sortedNumbers;
    }

    @Override
    public int[] sortArray(int[] array) {
        return bubbleSort(array);
    }

    @Override
    public double getTimeTaken() {
        return finishTime - startTime;
    }

    @Override
    public String toString() {return "BubbleSort";}
}
