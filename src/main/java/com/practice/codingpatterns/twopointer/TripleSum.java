package com.practice.codingpatterns.twopointer;

import java.util.*;

public class TripleSum {

    public static List<int[]> findTripletSums(int[] input, int targetSum) {
        //fix first item and try finding pair with given sum in the remaining array

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int remaining = targetSum - input[i];
            int k = 0;
            int left = i + 1;
            int right = input.length - 1;
            Set<Integer> set = new HashSet<>();
            while (left <= right) {
                int newSum = remaining - input[left];
                if(set.contains(newSum)) {
                    System.out.println(" Found triple " + input[i] + " , " + input[left] + ", " + newSum);
                    result.add(new int[] {input[i], input[left], newSum});
                    break;
                } else {
                    set.add(input[left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, -2, 3, 4, 1, 2, 7};
        int target = 8;
        List<int[]> tripletSums = findTripletSums(arr, target);
        tripletSums.forEach(data -> {
            System.out.println(Arrays.toString(data));
        });
        System.out.println("triple is " + tripletSums);
    }
}
