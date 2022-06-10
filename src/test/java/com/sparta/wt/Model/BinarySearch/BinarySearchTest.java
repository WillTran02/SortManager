package com.sparta.wt.Model.BinarySearch;

import com.sparta.wt.LogConfiguration;
import com.sparta.wt.Exceptions.ChildNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;


public class BinarySearchTest {

    private static final Logger logger = LogConfiguration.getLogger();

    @BeforeAll
    static void setup() {
        logger.setLevel(Level.OFF);
    }

    @Test
    @DisplayName("Check: Instantiate a Binary Tree with a root of 50")
    void checkRootFifty() {
        BinaryTree tree = new BinaryTree(50);
        Assertions.assertEquals(50, tree.getRootElement());
    }

    @Test
    @DisplayName("Check: Count number of elements in tree adding single elements")
    void checkCountOfElements() {
        BinaryTree tree = new BinaryTree(50);
        tree.addElement(15);
        tree.addElement(70);
        Assertions.assertEquals(3, tree.getNumberOfElements());
    }

    @Test
    @DisplayName("Check: Count number of elements in tree adding an array of elements")
    void checkCountOfElementsMulti() {
        BinaryTree tree = new BinaryTree(50);
        tree.addElements(new int[]{12, 92, 33});
        Assertions.assertEquals(4, tree.getNumberOfElements());
    }

    @Test
    @DisplayName("Check: Find a specific element")
    void checkFindingSpecificElement() {
        BinaryTree tree = new BinaryTree(50);
        tree.addElements(new int[]{12, 92, 33, 57});
        Assertions.assertTrue(tree.findElement(12));
        Assertions.assertFalse(tree.findElement(102));
    }

    @Test
    @DisplayName("Check: Find left child of element, or throw exception")
    void checkFindingLeftChild() throws ChildNotFoundException {
        BinaryTree tree = new BinaryTree(50);
        tree.addElements(new int[]{12, 92});
        Assertions.assertEquals(12, tree.getLeftChild(50));
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getLeftChild(12));
    }

    @Test
    @DisplayName("Check: Find Right child of element, or throw exception")
    void checkFindingRightChild() throws ChildNotFoundException {
        BinaryTree tree = new BinaryTree(50);
        tree.addElements(new int[]{12, 92});
        Assertions.assertEquals(92, tree.getRightChild(50));
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getRightChild(92));
    }

    @Test
    @DisplayName("Check: Get a sorted array ascending")
    void checkSortArrayAsc() {
        BinaryTree tree = new BinaryTree(50);
        tree.addElements(new int[]{12, 92, 17, 33});
        Assertions.assertArrayEquals(new int[]{12, 17, 33, 50, 92}, tree.getSortedTreeAsc());
    }

    @Test
    @DisplayName("Check: Get a sorted array descending")
    void checkSortArrayDesc() {
        BinaryTree tree = new BinaryTree(50);
        tree.addElements(new int[]{12, 92, 17, 33});
        Assertions.assertArrayEquals(new int[]{92, 50, 33, 17, 12}, tree.getSortedTreeDesc());
    }

}
