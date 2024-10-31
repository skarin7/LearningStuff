package com.practice.codingpatterns.slidingwindow;

public class MaxSubArraySum {


    int maxSubArraySum(int[] input, int k) {

        if(k > input.length) {
            System.out.println(" k can't be > input size");
            return 0;
        }
        //Find the base widow sum
        int windowSum = 0;
        for (int i=0; i< k; i++) {
            windowSum+= input[i];
        }

        int maxSum = windowSum;
        //now try to move window by moving to one step right side and calculate new sum to see if it is more than the max
        for (int i = k; i < input.length; i++) {
            windowSum += input[i] - input[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,4,7,8,9};
        int k = 6; //max sub array sum with size k

        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int sum = maxSubArraySum.maxSubArraySum(array, k);
        System.out.println(" Max sub array sum is " + sum);
    }
}
