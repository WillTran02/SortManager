package com.sparta.wt.View;

import com.sparta.wt.Controller.SortManager;
import com.sparta.wt.Model.Sorter;

import java.util.Scanner;

public class DisplayManager {
    private static Sorter chosenSorter;
    private static String input;
    private static boolean valid = false;
    private static Scanner console = new Scanner(System.in);

    public static void start() {
        System.out.println("Hello and welcome to the Sort Manager!");
        System.out.println("To begin with, please enter a number 1-3 \nto decide what sort method to use!");
        confirmInputForChosenSorter();
        System.out.println("Okay! You have chosen to use: " + chosenSorter + "!");
        System.out.println("Now please enter a number, to create an array of this size: ");
        valid = false;
        input = null;
    }

    private static void confirmInputForChosenSorter() {
        while (!valid) {
            System.out.println("1. BubbleSort\n2. MergeSort\n3. TreeSort");
            input = console.nextLine();
            if (input == null) {
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
}
