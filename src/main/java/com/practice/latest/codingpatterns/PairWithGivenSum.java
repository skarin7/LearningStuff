package com.practice.latest.codingpatterns;

import java.util.Arrays;

public class PairWithGivenSum {

    protected int[] find(int[] input, int targetSum) {
        // for each item, find out corresponding (targetSUm - itemvalue) in the remaining array.. using binary search
        //Complexity: O(n*logn)
        //Can we reduce furthur? Use two pointers..
        int start = 0, end = input.length - 1;
//        int[][] result = new int[input.length][];
        while (start < end) {
//            int desired = targetSum - input[start];
            int total = input[start] + input[end];
            if(total == targetSum) {
                return new int[] {start, end};
            }
            if(total > targetSum) {
                end--;
            } else {
                start++;
            }

        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int givenSum  = 19;
        int[]  input = new int[] {1,5,7,9,10,12};

        PairWithGivenSum pairWithGivenSum = new PairWithGivenSum();
        System.out.printf("result " + Arrays.toString(pairWithGivenSum.find(input, givenSum)));
    }
}
