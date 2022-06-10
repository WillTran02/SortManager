package com.sparta.wt.model.binary_tree_sort;

import com.sparta.wt.exceptions.ChildNotFoundException;
import com.sparta.wt.LogConfiguration;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree implements BinaryTreeInterface {

    private Logger logger = LogConfiguration.getLogger();

    private static class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) { this.value = value; }

        //No setter for value because node values do not change
        public void setLeftChild(Node leftChild) {this.leftChild = leftChild;}
        public void setRightChild(Node rightChild) {this.rightChild = rightChild;}

        public int getValue() {return value;}
        public Node getLeftChild() {return leftChild;}
        public Node getRightChild() {return rightChild;}

        public boolean hasLeftChild() {return leftChild != null;}
        public boolean hasRightChild() {return rightChild != null;}
    }

    //public method - User Interface
    //private method - Implementation Logic
    private Node rootNode; //Tracking the root of tree
    private int numberOfNodes = 1; //Tracking number of nodes in tree
    private int arrayIndex = 0; //Used with treeArray to fill array with sorted values
    private int[] treeArray; //Will be reinitialized when getSortedTreeAsc or getSortedTreeDesc is called

    public BinaryTree(final int element) {
        rootNode = new Node(element);
        logger.log(Level.INFO, "New BinaryTree instantiated! rootNode: " + rootNode.getValue());
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfNodes;
    }

    @Override
    public void addElement(int element) {
        if (rootNode == null) {
            logger.log(Level.INFO, "Rootnode empty, now adding " + element + " as rootnode");
            rootNode = new Node(element);
            return;
        }
        logger.log(Level.INFO, "Now adding: " + element);
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        logger.log(Level.INFO, "Now adding array: " + Arrays.toString(elements));
        for (int e : elements) {
            addNodeToTree(rootNode, e);
        }
    }

    @Override
    public boolean findElement(int element) {
        logger.log(Level.INFO, "Now finding: " + element);
        return findNode(element) != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        logger.log(Level.INFO, "Left Child of " + element + " requested");
        return getLeftChildNode(element);
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        logger.log(Level.INFO, "Right Child of " + element + " requested");
        return getRightChildNode(element);
    }

    @Override
    public int[] getSortedTreeAsc() {
        logger.log(Level.INFO, "New Sorted Tree Ascending requested");
        return sortTreeAsc(rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {
        logger.log(Level.INFO, "New Sorted Tree Descending requested");
        return sortTreeDesc(rootNode);
    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            if (!node.hasLeftChild()) {
                Node leftChild = new Node(element);
                node.setLeftChild(leftChild);
                numberOfNodes++;
                logger.log(Level.INFO, "Adding new node to tree: " + element + " as the left child of " + node.getValue());
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else { //element > node.getValue()
            if (!node.hasRightChild()) {
                Node rightChild = new Node(element);
                node.setRightChild(rightChild);
                numberOfNodes++;
                logger.log(Level.INFO, "Adding new node to tree: " + element + " as the right child of " + node.getValue());
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private Node findNode(final int element) {
        logger.log(Level.INFO, "Now searching for node: " + element);
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                logger.log(Level.INFO, "Node found: " + node.getValue());
                return node;
            } else if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        logger.log(Level.INFO, "Node " + element + " not found.");
        return null;
    }

    private int getLeftChildNode(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            Node currentNode = findNode(element);
            if (currentNode.hasLeftChild()) {
                logger.log(Level.INFO, "Left child of node " + currentNode.getValue() + " has been found: " + currentNode.getLeftChild().getValue());
                return currentNode.getLeftChild().getValue();
            }
        }
        logger.log(Level.INFO, "Left child of node " + element + " does not exist.");
        throw new ChildNotFoundException("" + element);
    }

    private int getRightChildNode(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            Node currentNode = findNode(element);
            if (currentNode.hasRightChild()) {
                logger.log(Level.INFO, "Right child of node " + currentNode.getValue() + " has been found: " + currentNode.getRightChild().getValue());
                return currentNode.getRightChild().getValue();
            }
        }
        logger.log(Level.INFO, "Right child of node " + element + " does not exist.");
        throw new ChildNotFoundException("" + element);
    }

    private int[] sortTreeAsc(Node node) {
        treeArray = new int[numberOfNodes]; //Reinitialize array to size of tree
        logger.log(Level.INFO, "New treeArray of size " + treeArray.length + " has been created.");
        traverseAsc(node);
        arrayIndex = 0; //Reset arrayIndex in case of needing to call sort method again
        logger.log(Level.INFO, "treeArray has been created and returned: " + Arrays.toString(treeArray));
        return treeArray;
    }

    private void traverseAsc(Node node) {
        if (node == null) return; //Ignore node if doesn't exist
        traverseAsc(node.getLeftChild());
        logger.log(Level.INFO, "Now adding: " + node.getValue() + " to treeArray: " + Arrays.toString(treeArray));
        treeArray[arrayIndex++] = node.getValue();
        traverseAsc(node.getRightChild());
    }

    private int[] sortTreeDesc(Node node) {
        treeArray = new int[numberOfNodes]; //Reinitialize array to size of tree
        logger.log(Level.INFO, "New treeArray of size " + treeArray.length + " has been created.");
        traverseDesc(node);
        arrayIndex = 0; //Reset arrayIndex in case of needing to call sort method again
        logger.log(Level.INFO, "treeArray has been created and returned: " + Arrays.toString(treeArray));
        return treeArray;
    }

    private void traverseDesc(Node node) {
        logger.log(Level.INFO, "Now traversing: " + (node==null ? "an empty space." : node.getValue()));
        if (node == null) return; //Ignore node if doesn't exist
        traverseDesc(node.getRightChild());
        logger.log(Level.INFO, "Now adding: " + node.getValue() + " to treeArray: " + Arrays.toString(treeArray));
        treeArray[arrayIndex++] = node.getValue();
        traverseDesc(node.getLeftChild());
    }

}
