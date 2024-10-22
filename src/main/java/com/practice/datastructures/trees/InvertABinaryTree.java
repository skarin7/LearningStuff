package com.practice.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertABinaryTree {

    static class MyTreeNode {
        private int data;
        private MyTreeNode left;
        private MyTreeNode right;


        public MyTreeNode(int data, MyTreeNode left, MyTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public MyTreeNode(int data) {
            this(data, null, null);
        }

        public MyTreeNode getLeft() {
            return left;
        }

        public MyTreeNode getRight() {
            return right;
        }


        public void setLeft(MyTreeNode left) {
            this.left = left;
        }

        public void setRight(MyTreeNode right) {
            this.right = right;
        }


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    /**
     * CHange left node to right at every level
     * @return
     */
    MyTreeNode invertTree(MyTreeNode root) {

        if(root == null) {
            return null;
        }

        //swap left to right recursivly

        MyTreeNode leftSubtree = invertTree(root.getLeft());
        MyTreeNode rightSubtree = invertTree(root.getRight());

        root.setLeft(rightSubtree); //set the left node as right
        root.setRight(leftSubtree); //set the right as left.

        
        return root;
    }

    MyTreeNode invertBFS(MyTreeNode root) {
        Queue<MyTreeNode> levelOrderQue = new LinkedList<>();

        levelOrderQue.offer(root);//add root

        while (!levelOrderQue.isEmpty()) {
            //at each level

            int leveSize = levelOrderQue.size();

            for (int i = 0; i < leveSize; i++) {
                MyTreeNode current = levelOrderQue.poll();
                if(current.getLeft() != null) {
                    levelOrderQue.offer(current.getLeft());
                }
                if(current.getRight() != null) {
                    levelOrderQue.offer(current.getRight());
                }

                MyTreeNode temp = current.getLeft();
                current.setLeft(current.getRight());
                current.setRight(temp);
            }

        }

        return root;
    }

    void print(MyTreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.getData() + " ");
        print(root.getLeft());
        print(root.getRight());

    }

    public static void main(String[] args) {

        InvertABinaryTree driver = new InvertABinaryTree();
        MyTreeNode root = new MyTreeNode(1);
        root.setLeft(new MyTreeNode(2));
        root.setRight(new MyTreeNode(3));

        root.getLeft().setLeft(new MyTreeNode(4));
        root.getLeft().setRight(new MyTreeNode(5));

        root.getRight().setLeft(new MyTreeNode(6));
        root.getRight().setRight(new MyTreeNode(7));

        System.out.println("Before inverting a tree " );
        driver.print(root);

/*
        driver.invertTree(root);

        System.out.println("After inverting using recursion ..");
        driver.print(root);
*/

        driver.invertBFS(root);

        System.out.println("After inverting using BFS..");
        driver.print(root);

    }


}
