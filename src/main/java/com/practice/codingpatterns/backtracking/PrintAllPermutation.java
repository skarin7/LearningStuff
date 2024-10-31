package com.practice.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printPermutations(arr);
    }

    public static void printPermutations(int[] arr) {
        Queue<String> queue = new LinkedList<>();
        // Start with an empty string (representing an empty permutation)
        queue.offer("");

        for (int num : arr) {
            int size = queue.size(); // Number of current permutations
            // Process each existing permutation
            for (int i = 0; i < size; i++) {
                String current = queue.poll(); // Get the current permutation

                // Insert the new number in every possible position
                for (int j = 0; j <= current.length(); j++) {
                    String newPermutation = current.substring(0, j) + num + current.substring(j);
                    System.out.println(" New permutation is" + newPermutation);
                    queue.offer(newPermutation); // Enqueue the new permutation
                }
            }
        }

        // Print all permutations stored in the queue
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
