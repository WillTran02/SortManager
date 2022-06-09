package com.sparta.wt.View;

import com.sparta.wt.Controller.SortManager;
import com.sparta.wt.Model.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DisplayManager {

    private static String input;
    private static Sorter chosenSorter; //Holder for input -> choice of sorting algorithm
    private static int arraySize; //Holder for input -> size of the array to be generated
    private static boolean valid = false; //boolean flag for validation of user input
    private static final Scanner console = new Scanner(System.in); //User input stream
    private static final Random random = new Random(); //Random number generator

    public static void start() {
        boolean repeating; //boolean flag for if the program should re-run or not
        do {
            valid = false; //Reset flag
            input = null; //Reset input
            System.out.println("Hello and welcome to the Sort Manager!\n");
            System.out.println("To begin with, please enter a number 1-3 \nto decide what sort method to use!");
            confirmInputForChosenSorter();
            System.out.println("-------------------\nOkay! You have chosen to use: " + chosenSorter + "!");
            System.out.println("Now to create an array of random numbers!");
            valid = false; //Reset flag
            input = null; //Reset input
            confirmInputForArraySize();
            int[] arrayOfNumbers = new int[arraySize]; //Create primitive int array of size requested by user
            fillArrayWithRandomNumbers(arrayOfNumbers);
            System.out.println("-------------------\nLet's start!\nYour array of size " + arraySize + " and random numbers:\n" + Arrays.toString(arrayOfNumbers));
            System.out.println("-------------------\nYour chosen sorting algorithm: " + chosenSorter);
            double start = System.nanoTime();
            int[] sortedArray = chosenSorter.sortArray(arrayOfNumbers); //Create new array of sorted numbers
            double sortTime = System.nanoTime() - start;
            System.out.println("-------------------\nYour array, sorted:\n" + Arrays.toString(sortedArray));
            System.out.println("-------------------\nTime taken to complete the sort: " + sortTime / 1_000_000 + "ns");
            valid = false; //Reset flag
            input = null; //Reset input
            repeating = confirmInputForRepeat();
        } while (repeating);
        System.out.println("Thank you for using the Sort Manager!"); //Exit program
    }

    private static boolean confirmInputForRepeat() {
        System.out.println("Would you like to re-run the program?\n[Y] for yes, or any other key to close.");
        input = console.nextLine();
        return input.equalsIgnoreCase("y"); //"y" (case insensitive) to repeat, anything else exits program
    }

    private static void fillArrayWithRandomNumbers(int[] arrayOfNumbers) {
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = random.nextInt(1000);
        }
    }

    private static void confirmInputForChosenSorter() {
        while (!valid) { //Repeat until valid is true
            System.out.println("1. BubbleSort\n2. MergeSort\n3. TreeSort");
            input = console.nextLine();
            if (input == null || input.equals("")) {
                System.out.println("Please enter a number from 1-3."); //Message for if no input was detected, or input was empty
                continue;
            }
            try {
                chosenSorter = SortManager.getSortMethod(input); //Attempt to put user input into an int, may throw an exception
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); //Print exception message, repeat input request
                continue;
            }
            valid = true;
        }
    }

    private static void confirmInputForArraySize() {
        while (!valid) {
            System.out.println("CAUTION! Entering numbers greater than " + Integer.MAX_VALUE + "\nor smaller than " + Integer.MIN_VALUE + " will be rejected!");
            System.out.println("Please enter a number:");
            input = console.nextLine();
            if (input == null || input.equals("")) {
                continue; //If input is empty, repeat input request
            }
            try {
                arraySize = SortManager.getArraySize(input); //Attempt to assign user input into int, may throw an exception
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); //Print exception message, repeat input request
                continue;
            }
            valid = true;
        }
    }
}
