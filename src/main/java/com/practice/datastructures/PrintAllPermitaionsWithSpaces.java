package com.practice.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shankark on 17/12/16.
 */
public class PrintAllPermitaionsWithSpaces {

    List<List<Integer>> print(List<Integer> input) {
        List<List<Integer>> allArrays = new ArrayList<>();
        for (int i= 0; i< input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                List<Integer> subArray = new ArrayList<>();
                for (int k = i; k <=j ; k++) {
                    subArray.add(input.get(k));
                }
                allArrays.add(subArray);
            }
        }

        return allArrays;
    }


    public static void main(String[] args) {
        List<Integer> input  = Arrays.asList(1,4,5);
        PrintAllPermitaionsWithSpaces test = new PrintAllPermitaionsWithSpaces();
        System.out.println(" All combos" + test.print(input));

    }
}
