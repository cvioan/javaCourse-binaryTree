package com.cioan.orderedBinaryTree;

import java.util.Iterator;
import java.util.Stack;

public class Tree implements Iterable<Node> {

    private Node root = null;

    public Tree cloneYourSelf() {
        Tree clone = new Tree();
        clone.root = this.root.copy();
        return clone;
    }

    public void add(int i) {
        if (root == null) {
            root = new Node(i);
        } else {
            Node.createChild(root, i);
        }

    }

    public void print(boolean asc) {
        if (root == null) {
            System.out.println("Empty Tree");
        } else {
            root.print(asc);
        }
    }

    public boolean equals(Tree ref) {
        return this.root.equals(ref.root);
    }

    private Stack<Node> getStack() {
        return this.root.getNodeStack();
    }

    public Iterator<Node> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<Node> {
        private Stack<Node> myStack = Tree.this.getStack();

        @Override
        public boolean hasNext() {
            return !myStack.empty();
        }

        @Override
        public Node next() {
            return myStack.pop();
        }
    }
}
