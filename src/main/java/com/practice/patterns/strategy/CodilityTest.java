package com.practice.patterns.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shankark on 25/1/17.
 */
public class CodilityTest {
    private static int count = 0;
    public int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        int finalMax = 0;
        int val;
        int partMax = 0;
        for (int i = 0; i < length; i++) {
            if(i < length - 1) {
                partMax = maxIn(A, i + 1, length - 1);
            }

            val = Math.abs(maxIn(A, 0, i) - partMax);
            if(val > finalMax) {
                finalMax = val;
            }

        }
        return finalMax;

    }

    int maxIn(int[] A, int beginIndex, int endIndex) {
        int max = A[beginIndex];
        for(int i = beginIndex; i <= endIndex; i++ ) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    int getNumberOfPermutation (Integer num) {
        List<Integer> arrayList = new ArrayList<Integer>();
        int temp = num;
        do {
            arrayList.add(temp%10);
            temp/= 10;
        }while (temp > 0);
        Collections.reverse(arrayList);
        permuteArrayOfIntegers(arrayList, 0);
        return count/2;
    }

    void permuteArrayOfIntegers(List<Integer> arrayList, int digit) {
        for(int i = digit; i < arrayList.size(); i++){
            java.util.Collections.swap(arrayList, i, digit);
            permuteArrayOfIntegers(arrayList, digit+1);
            java.util.Collections.swap(arrayList,digit, i);
        }
        if (digit == arrayList.size() -1){
            count++;
        }
    }

    void  permute(Integer number) {
        System.out.println(getNumberOfPermutation(number));
    }


    public static void main(String[] args) {
        CodilityTest test = new CodilityTest();

        int[] A = {5,1};
//        System.out.println(test.maxIn(A, 6, A.length - 1));
//        System.out.println(test.solution(A));


        test.permute(1213);
    }


}
