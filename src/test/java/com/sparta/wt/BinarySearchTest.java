package com.sparta.wt;

import com.sparta.wt.Model.BinarySearch.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

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
        Assertions.assertEquals(true, tree.findElement(12));
        Assertions.assertEquals(false, tree.findElement(102));
    }

}
