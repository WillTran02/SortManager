package com.sparta.wt.Model.BubbleSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleTest {

    @Test
    @DisplayName("check: return {1} when entering {1}")
    void checkReturnSingleIntArray() {
        int[] numbers = {1};
        numbers = Bubble.bubbleSort(numbers);
        Assertions.assertArrayEquals(new int[]{1}, numbers);
    }

    @Test
    @DisplayName("check: return {1, 2, 3} when entering {3, 1, 2}")
    void checkSortIsFunctional() {
        int[] numbers = {3, 1, 2};
        numbers = Bubble.bubbleSort(numbers);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, numbers);
    }

    @Test
    @DisplayName("check: return {-5, -3, -1} when entering {-1, -3, -5}")
    void checkNegativeSort() {
        int[] numbers = {-1, -3, -5};
        numbers = Bubble.bubbleSort(numbers);
        Assertions.assertArrayEquals(new int[]{-5, -3, -1},numbers);
    }

    @Test
    @DisplayName("check: return {-5, 0, 5} when entering {0, 5, -5}")
    void checkNegativeAndPositiveSort() {
        int[] numbers = {0, 5, -5};
        numbers = Bubble.bubbleSort(numbers);
        Assertions.assertArrayEquals(new int[]{-5, 0, 5},numbers);
    }

    @Test
    @DisplayName("check: return {MIN_VALUE, 0, MAX_VALUE when entering {0, MIN_VALUE, MAX_VALUE")
    void checkMinMaxSort() {
        int[] numbers = {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        numbers = Bubble.bubbleSort(numbers);
        Assertions.assertArrayEquals(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE},numbers);
    }

    @Test
    @DisplayName("check: sorting a long array")
    void check() {
        int[] numbers = {154, -912, 615, 891, 649};
        numbers = Bubble.bubbleSort(numbers);
        Assertions.assertArrayEquals(new int[]{-912, 154, 615, 649, 891},numbers);
    }


}
