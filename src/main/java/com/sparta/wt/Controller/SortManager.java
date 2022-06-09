package com.sparta.wt.Controller;

import com.sparta.wt.Model.BinarySearch.TreeSort;
import com.sparta.wt.Model.BubbleSort.Bubble;
import com.sparta.wt.Model.MergeSort.Merge;
import com.sparta.wt.Model.Sorter;

public class SortManager {
    public static Sorter getSortMethod(String input) {
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You have entered something invalid: " + input + "\nPlease enter a number between 1-3.");
        }
        switch (option) {
            case 1:
                return new Bubble();
            case 2:
                return new Merge();
            case 3:
                return new TreeSort();
            default:
                throw new IllegalArgumentException("" + option + " was not one of the available options.\nPlease enter a number between 1-3.");
        }
    }

    public static int getArraySize(String input) {
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You have entered something invalid: " + input);
        }
        return option;
    }
}
