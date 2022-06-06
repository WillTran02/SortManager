package com.sparta.wt.Model.BinarySearch;

public class BinaryTree implements BinaryTreeInterface {

    //public method - Interface
    //private method - Implementation
    private final Node rootNode;
    private int numberOfNodes = 1;

    public BinaryTree(final int element) {rootNode = new Node(element);}
    //new BinaryTreeBuilder(100) creates a new binary tree, where root node
    //has value 100. Nodes have been hidden from user.

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfNodes;
    }

    @Override
    public void addElement(int element) {addNodeToTree(rootNode, element);}

    @Override
    public void addElements(int[] elements) {
        for (int e : elements) {
            addNodeToTree(rootNode, e);
        }
    }

    public boolean findElement(int element) {return findNode(element) != null;}

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            if (!node.hasLeftChild()) {
                Node leftChild = new Node(element);
                node.setLeftChild(leftChild);
                numberOfNodes++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else { //element > node.getValue()
            if (!node.hasRightChild()) {
                Node rightChild = new Node(element);
                node.setRightChild(rightChild);
                numberOfNodes++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private Node findNode(final int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            } else if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

}
