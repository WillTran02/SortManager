package com.sparta.wt.View;

import com.sparta.wt.Controller.SortManager;
import com.sparta.wt.Model.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DisplayManager {

    private static String input;
    private static Sorter chosenSorter;
    private static int arraySize;
    private static int[] arrayOfNumbers;
    private static boolean valid = false;
    private static boolean repeating = false;
    private static final Scanner console = new Scanner(System.in);
    private static final Random random = new Random();

    public static void start() {
        do {
            valid = false;
            input = null;
            System.out.println("Hello and welcome to the Sort Manager!\n");
            System.out.println("To begin with, please enter a number 1-3 \nto decide what sort method to use!");
            confirmInputForChosenSorter();
            System.out.println("-------------------\nOkay! You have chosen to use: " + chosenSorter + "!");
            System.out.println("Now to create an array of random numbers!");
            valid = false;
            input = null;
            confirmInputForArraySize();
            arrayOfNumbers = new int[arraySize];
            fillArrayWithRandomNumbers(arrayOfNumbers);
            System.out.println("-------------------\nLet's start!\nYour array of size " + arraySize + " and random numbers:\n" + Arrays.toString(arrayOfNumbers));
            System.out.println("-------------------\nYour chosen sorting algorithm: " + chosenSorter);
            int[] sortedArray = chosenSorter.sortArray(arrayOfNumbers);
            System.out.println("-------------------\nYour array, sorted:\n" + Arrays.toString(sortedArray));
            System.out.println("-------------------\nTime taken to complete the sort: ");
            valid = false;
            input = null;
            repeating = confirmInputForRepeat();
        } while (repeating);
        System.out.println("Thank you for using the Sort Manager!");
    }

    private static boolean confirmInputForRepeat() {
        System.out.println("Would you like to re-run the program?\n[Y] for yes, or any other key to close.");
        input = console.nextLine();
        return input.equalsIgnoreCase("y");
    }

    private static void fillArrayWithRandomNumbers(int[] arrayOfNumbers) {
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = random.nextInt(1000);
        }
    }

    private static void confirmInputForChosenSorter() {
        while (!valid) {
            System.out.println("1. BubbleSort\n2. MergeSort\n3. TreeSort");
            input = console.nextLine();
            if (input == null || input.equals("")) {
                System.out.println("Please enter a number from 1-3.");
                continue;
            }
            try {
                chosenSorter = SortManager.getSortMethod(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            valid = true;
        }
    }

    private static void confirmInputForArraySize() {
        while (!valid) {
            System.out.println("Please enter a number:");
            System.out.println("CAUTION! Entering numbers greater than " + Integer.MAX_VALUE + "\nor smaller than " + Integer.MIN_VALUE + " will be rejected!");
            input = console.nextLine();
            if (input == null || input.equals("")) {
                continue;
            }
            try {
                arraySize = SortManager.getArraySize(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            valid = true;
        }
    }
}
