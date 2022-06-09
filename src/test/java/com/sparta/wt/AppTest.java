package com.sparta.wt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sparta.wt.Controller.SortManager;
import com.sparta.wt.Model.BinarySearch.TreeSort;
import com.sparta.wt.Model.BubbleSort.Bubble;
import com.sparta.wt.Model.MergeSort.Merge;

public class AppTest {
    @Test
    @DisplayName("check SortManager: getSortMethod(1) returns Bubble")
    void checkBubble() {
        Assertions.assertSame(SortManager.getSortMethod("1").getClass(), Bubble.class);
     }

    @Test
    @DisplayName("check SortManager: getSortMethod(2) returns Merge")
    void checkMerge() {
        Assertions.assertSame(SortManager.getSortMethod("2").getClass(), Merge.class);
    }

    @Test
    @DisplayName("check SortManager: getSortMethod(3) returns Tree")
    void checkTree() {
        Assertions.assertSame(SortManager.getSortMethod("3").getClass(), TreeSort.class);
    }

    @Test
    @DisplayName("check SortManager: getArraySize(100) returns int 100")
    void checkArraySize() {
        Assertions.assertEquals(100, SortManager.getArraySize("100"));
    }



}
