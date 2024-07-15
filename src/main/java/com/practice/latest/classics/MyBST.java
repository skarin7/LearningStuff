package com.practice.latest.classics;

public class MyBST {
    BSTNode root;

    class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;


        BSTNode(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    MyBST() {
        root = null;
    }
    MyBST(int data) {
        root = new BSTNode(data);
    }

    void addNode(int data) {
        addNodeInternal(root, data);
    }

    BSTNode addNodeInternal (BSTNode refNode, int x) {
        if (refNode == null) {
            refNode = new BSTNode(x);
            return refNode;
        }

        if(x > refNode.data) {
            refNode.right = addNodeInternal(refNode.right, x);
        } else if (x < refNode.data) {
            refNode.left = addNodeInternal(refNode.left, x);
        }

        return refNode;
    }



}
