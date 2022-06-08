package com.sparta.wt.Model.BinarySearch;

import com.sparta.wt.Model.Sorter;

public class Binary implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        BinaryTree tree = new BinaryTree(array[0]);
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {return "BinarySort";}
}
