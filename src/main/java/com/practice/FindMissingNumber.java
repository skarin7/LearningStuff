package com.practice;

import java.util.Arrays;
import java.util.List;

public class FindMissingNumber {
    public static void main(String[] args) {
        int numbers = 7;
        List<Integer> nums = Arrays.asList(1,2,3,4,6,7);

        //XOR of any number with same is 0
        //XOR of any number with 0 is same number
        int xorArray = 0;
        int xorFUll  = 0;
        for (int num : nums) {
            xorArray ^= num;
        }
        for (int i = 0; i <=numbers; i++) {
            xorFUll ^= i;
        }

        System.out.println(" Missing  num is " + (xorArray ^ xorFUll));
    }
}
