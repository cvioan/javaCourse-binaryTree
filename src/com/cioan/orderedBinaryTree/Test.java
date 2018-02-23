package com.cioan.orderedBinaryTree;

public class Test {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.add(7);
        tree.add(3);
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(7);
        tree.add(11);
        tree.add(21);
        tree.add(1);
        tree.add(4);
        tree.add(16);
        tree.print(true);
        System.out.println();
        System.out.println();
        System.out.println();
        Tree clone = tree.cloneYourSelf();
        System.out.println();
        clone.add(13);
        tree.add(13);
        boolean a = clone.equals(tree);
        System.out.println(a);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        clone.print(true);
        System.out.println();
        System.out.println();
        System.out.println("Next: Iterator stuff");
        System.out.println();

        for (Node nod : tree) {
            System.out.println(nod);
        }
    }
}
