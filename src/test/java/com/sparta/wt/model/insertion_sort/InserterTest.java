package com.sparta.wt.model.insertion_sort;

import com.sparta.wt.LogConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InserterTest {

    private static final Logger logger = LogConfiguration.getLogger();
    int[] singleValueArray = new int[] {1};
    int[] unsortedArray = new int[] {5, 1, 2, 4, 3};
    int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    int[] negativeArray = new int[] {5, -5, 1, -3, -1, 3};
    int[] negativeSortedArray = new int[] {-5, -3, -1, 1, 3, 5};

    Inserter insertSorter = new Inserter();

    @BeforeAll
    static void setup() {
        logger.setLevel(Level.OFF);
    }

    @Test
    @DisplayName("check: return null from null")
    void checkNull() {
        Assertions.assertNull(insertSorter.sortArray(null));
    }

    @Test
    @DisplayName("check: return {} from {}")
    void checkEmpty() {
        int[] empty = new int[0];
        Assertions.assertEquals(empty, insertSorter.sortArray(empty));
    }

    @Test
    @DisplayName("check: return {1} from {1}")
    void checkSingleValueArray() {
        Assertions.assertArrayEquals(singleValueArray, insertSorter.sortArray(singleValueArray));
    }

    @Test
    @DisplayName("check: return {1, 2, 3, 4, 5} from unsorted array")
    void checkSortUnsortedArray() {
        Assertions.assertArrayEquals(sortedArray, insertSorter.sortArray(unsortedArray));
    }

    @Test
    @DisplayName("check: return {-5, -3, -1, 1, 3, 5} from unsorted array")
    void checkSortNegativeUnsortedArray() {
        Assertions.assertArrayEquals(negativeSortedArray, insertSorter.sortArray(negativeArray));
    }
}
