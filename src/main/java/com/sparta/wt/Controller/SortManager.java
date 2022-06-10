package com.sparta.wt.Controller;

import com.sparta.wt.LogConfiguration;
import com.sparta.wt.Model.BinarySearch.TreeSort;
import com.sparta.wt.Model.BubbleSort.Bubble;
import com.sparta.wt.Model.InsertionSort.Inserter;
import com.sparta.wt.Model.MergeSort.Merge;
import com.sparta.wt.Model.Sorter;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortManager {

    private static final Logger logger = LogConfiguration.getLogger();
    private static final Random random = new Random(); //Random number generator

    public static Sorter getSortMethod(String input) {
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You have entered something invalid: " + input + "\nPlease enter a number between 1-4.");
        }
        switch (option) {
            case 1:
                logger.log(Level.INFO, "Request received: BubbleSort");
                return new Bubble();
            case 2:
                logger.log(Level.INFO, "Request received: MergeSort");
                return new Merge();
            case 3:
                logger.log(Level.INFO, "Request received: TreeSort");
                return new TreeSort();
            case 4:
                logger.log(Level.INFO, "Request received: InsertionSort");
                return new Inserter();
            default:
                logger.log(Level.INFO, "Exception: The input was not a valid option");
                throw new IllegalArgumentException("" + option + " was not one of the available options.\nPlease enter a number between 1-4.");
        }
    }

    public static int getArraySize(String input) {
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            logger.log(Level.INFO, "Exception: The input was not a valid option");
            throw new IllegalArgumentException("You have entered something invalid: " + input);
        }
        return option;
    }

    public static void fillArrayWithRandomNumbers(int[] arrayOfNumbers) {
        logger.log(Level.INFO, "Now populating Array:" + arrayOfNumbers + " with random numbers...");
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = random.nextInt(1000);
        }
    }

}
