package com.sparta.wt.Model.BinarySearch;

import com.sparta.wt.Model.Sorter;

public class TreeSort implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        BinaryTree tree = new BinaryTree(array[0]);
        for (int i = 1; i < array.length; i++) {
            tree.addElement(array[i]);
        }
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {return "TreeSort";}
}
