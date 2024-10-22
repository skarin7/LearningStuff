package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutation {

    // Function to find the possible permutations.
    static void permutations(List<List<Integer>> res,
                             int[] arr, int idx) {

        // Base case: if idx reaches the size of the array,
        // add the permutation to the result
        if (idx == arr.length) {
            res.add(convertArrayToList(arr));
            return;
        }

        // Permutations made by swapping each element
        // starting from index `idx`
        for (int i = idx; i < arr.length; i++) {
            // Swapping
            swap(arr, idx, i);

            // Recursive call to create permutations
            // for the next element
            permutations(res, arr, idx + 1);

            // Backtracking
            swap(arr, idx, i);
        }
    }

    // Function to get the permutations
    static List<List<Integer>> permute(int[] arr) {

        // Declaring result variable
        List<List<Integer>> res = new ArrayList<>();

        // Calling permutations with idx starting at 0
        permutations(res, arr, 0);
        return res;
    }

    // Helper method to swap elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to convert array to list
    static List<Integer> convertArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> res = permute(arr);

        for (List<Integer> x : res) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
