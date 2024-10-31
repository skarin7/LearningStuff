package com.practice.codingpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ALLSubSets {

    static List<List<Integer>> findAllSubsets(List<Integer> input) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i=0; i < input.size() ; i++) {
            int size = subsets.size();
            for (int k = 0; k < size; k++) {
                List<Integer> set = new ArrayList<>(subsets.get(k));
                set.add(input.get(i));
                subsets.add(set);
            }
        }
        subsets.remove(0);
        return subsets;
    }
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,3,5,9);
        System.out.printf("Combos : " + findAllSubsets(input));
    }
}
