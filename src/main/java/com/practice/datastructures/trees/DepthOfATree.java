package com.practice.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfATree {

    private static class MyTreeNode {
        private int data;
        private MyTreeNode left;
        private  MyTreeNode right;


        public MyTreeNode(int data, MyTreeNode left, MyTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        public MyTreeNode getLeft() {
            return left;
        }

        public MyTreeNode getRght() {
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


    int depth(MyTreeNode root) {

        if(root == null) {
            return 0;
        }
        Queue<MyTreeNode> levelQueeue = new LinkedList<>();
        int depth = 0;
        levelQueeue.add(root);//add roo

        while (!levelQueeue.isEmpty()) {//loop it is empty
            int levelSize = levelQueeue.size();
            for (int i = 0; i < levelSize; i++) {
                MyTreeNode current = levelQueeue.poll();

                if(current.getLeft() != null) {
                    levelQueeue.offer(current.getLeft());
                }
                if(current.getRght() != null) {
                    levelQueeue.offer(current.getRght());
                }
            }
            depth++;
        }

        return depth - 1;
    }

    public static void main(String[] args) {
        //construct the tree
        MyTreeNode root = new MyTreeNode(10, null, null);


        MyTreeNode child1 = new MyTreeNode(1, null, null);
        MyTreeNode child11 = new MyTreeNode(11, null, null);
        child1.setLeft(child11);


        MyTreeNode child2 = new MyTreeNode(2, null, null);
        MyTreeNode child21 = new MyTreeNode(21, null, null);
        child2.setLeft(child21);


        root.setLeft(child1);
        root.setRight(child2);

        DepthOfATree depthFInder = new DepthOfATree();
        System.out.printf("Depth of a tree is " + depthFInder.depth(root));

    }
}
