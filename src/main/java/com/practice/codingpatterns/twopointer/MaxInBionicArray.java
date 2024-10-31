package com.practice.codingpatterns.twopointer;

public class MaxInBionicArray {

    int findMax(int[] input) {
        int start = 0, end = input.length - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if(input[mid] > input[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return input[start];
    }

/*    int findMaxUsingSinglePass(int[] input) {
        if(input.length == 0) {
            return 0;
        }

        //it is increasing pattern so check when the next value is less than cur value, else the opposite
        boolean increasing = input[1] > input[0];
        for (int num: input) {

        }

    }*/
    public static void main(String[] args) {
        //data increases and at some point it would start decreasing... need to findout the max point.
        //Data is always sorted.., need to use Binary Search to reduce the search space.

        //Rule of thumb, whenever the given input is sorted.. think of Binary solution.
        int[] input = new int[] {1,4,7,23,5,3,0};

        MaxInBionicArray drive = new MaxInBionicArray();
        System.out.printf("result" + drive.findMax(input));

    }
}
