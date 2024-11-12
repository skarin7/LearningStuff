package com.practice.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shankark on 17/12/16.
 */
public class MaxDistBetweenRepeatingNumbers {

    public static void main(String[] args) {
        int input[] = {1, 2, 3, 1, 4, 5, 2, 6, 1};
    MaxDistBetweenRepeatingNumbers test = new MaxDistBetweenRepeatingNumbers();
        System.out.println(test.maxDistanceUsingHash(input));
    }
    private int maxDistance(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int distance[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            Integer value = map.get(arr[i]);
            if(value != null) {
                distance[arr[i]] = i - value;
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println(Arrays.toString(distance));
        int max  = distance[0];
        for(int j = 1; j< distance.length; j++) {
            if(distance[j] > max) {
                max = distance[j];
            }
        }
        return max;
    }

    int maxDistanceUsingHash(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxDistance = 0;
        for (int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i])) {
                maxDistance = Math.max(maxDistance, (i - map.get(input[i])));
            } else {
                map.put(input[i], i);
            }
        }

        return maxDistance;
    }


}
