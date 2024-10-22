package com.practice.datastructures.trees;

/**
 * Created by shankark on 7/12/16.
 */
public class CustomBinaryTree {
    Node root = new Node(1);


    void addNode(int data) {

    }


    public static  class  Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
}
