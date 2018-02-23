package com.cioan.orderedBinaryTree;

import java.util.Stack;

public class Node {
    private static Stack<Node> nodes = null;
    private int value;
    private Node right;
    private Node left;

    public Node(int value) {
        this.value = value;
    }

    public static void createChild(Node currentNode, int i) {
        if (i <= currentNode.value) {
            if (currentNode.getLeft() == null) {
//                System.out.println("Added a new left: " + i);
                currentNode.setLeft(new Node(i));
            } else {
                createChild(currentNode.left, i);
            }
        } else {
            if (currentNode.getRight() == null) {
//                System.out.println("Added a new right: " + i);
                currentNode.setRight(new Node(i));
            } else {
                createChild(currentNode.right, i);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean hasLeft() {
        return this.getLeft() != null;
    }

    public boolean hasRight() {
        return this.getRight() != null;
    }

    public void print(boolean asc) {
        if (asc) {
            if (this.hasLeft()) {
                left.print(asc);
            }
            System.out.println(value);
            if (this.hasRight()) {
                right.print(asc);
            }
        } else {
            if (this.hasRight()) {
                right.print(asc);
            }
            System.out.println(value);
            if (this.hasLeft()) {
                left.print(asc);
            }
        }
    }

    public Node copy() {
        Node left = null;
        Node right = null;

        if (this.getLeft() != null) {
            left = this.left.copy();
        }
        if (this.getRight() != null) {
            right = this.right.copy();
        }

        Node cNode = new Node(value);
        cNode.setLeft(left);
        cNode.setRight(right);
        return cNode;
    }

    public boolean equals(Node ref) {
        if (ref == null) return false;

        boolean valuesEqual = this.value == ref.value;
        boolean leftEquals = this.left == null ? ref.left == null : this.left.equals(ref.left);
        boolean rightEquals = this.right == null ? ref.right == null : this.right.equals(ref.right);

        return valuesEqual && leftEquals && rightEquals;
    }

    public Stack<Node> getNodeStack() {

        if (this.hasRight()) {
            this.right.getNodeStack();
        }
        if (nodes == null) {
            nodes = new Stack<>();
        }
        nodes.push(this);
        if (this.hasLeft()) {
            this.left.getNodeStack();
        }

        return nodes;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
