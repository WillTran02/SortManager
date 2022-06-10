package com.sparta.wt.Model.BinarySearch;

import com.sparta.wt.Model.Sorter;

public class TreeSort implements Sorter {

    private static double startTime = 0;
    private static double finishTime = 0;

    @Override
    public int[] sortArray(int[] array) {
        BinaryTree tree = new BinaryTree(array[0]);
        for (int i = 1; i < array.length; i++) {
            tree.addElement(array[i]);
        }
        startTime = System.nanoTime();
        int[] sortedArray = tree.getSortedTreeAsc();
        finishTime = System.nanoTime();
        return sortedArray;
    }

    @Override
    public double getTimeTaken() {return finishTime - startTime;}

    @Override
    public String toString() {return "TreeSort";}
}
