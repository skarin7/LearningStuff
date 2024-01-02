package com.practice.latest.codingpatterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TreePathWithSum {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    boolean hasPath(TreeNode root, int value, StringBuffer path) {

        if(root == null) {
            return false;
        }
        path.append(root.value).append("->");

        if((root.left == null && root.right == null) && root.value == value) {
            System.out.printf("Path is " + path);
            return true;
        } else if (root.right == null && root.left == null) {
            //traversed to leaf node but sum is not equl.. then empty the path
            path.delete(3, path.length());
        }

        return hasPath(root.left, value- root.value, path) || hasPath(root.right,   value - root.value, path);
    }

    void inOrderTraversalWithoutRecursion(TreeNode root) {
        Stack<TreeNode> valueStack = new Stack<>();
        TreeNode current = root;
        while (current != null || !valueStack.isEmpty()) {

            while (current != null) {
                valueStack.add(current);
                current = current.left;
            }

            //Once left traversal is done, then print the data and move to right
            current = valueStack.pop();
            System.out.printf(String.valueOf(current.value) + ",");
            current = current.right;

        }

    }

    void inOrderRecursion(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrderRecursion(root.left);
        System.out.printf("" + root.value);
        inOrderRecursion(root.right);
    }

    Integer leafNodesSum(TreeNode root, int sum) {
        if(root == null) {
            return sum;
        }

        if (root.left == null && root.right == null) {
            return sum + root.value;
        }

       return leafNodesSum(root.left, sum) + leafNodesSum(root.right, sum);
    }



    public static void main(String[] args) {
        //2 -> [3,5}, 3 -> [10,9],
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(9);

    }


    @Before
    public void init() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(9);
        this.root = root;
    }

    TreeNode root;
    @Test
    public void testSumPossible() {
        Assert.assertTrue(hasPath(root, 15, new StringBuffer()));
        Assert.assertTrue(hasPath(root, 7, new StringBuffer()));
        Assert.assertTrue(hasPath(root, 14, new StringBuffer()));
    }

    @Test
    public void printInOrder() {
        inOrderTraversalWithoutRecursion(root);
    }

    @Test
    public void printInOrderRecursion() {
        inOrderRecursion(root);
    }

    @Test
    public void leafNodeSum() {
        Integer leafNodesSum = leafNodesSum(root, 0);
        System.out.printf("Sum "+ leafNodesSum);
        Assert.assertEquals(Integer.valueOf(24), leafNodesSum);
    }

}
