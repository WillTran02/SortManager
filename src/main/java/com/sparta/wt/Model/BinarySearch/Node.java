package com.sparta.wt.Model.BinarySearch;

public class Node {

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
