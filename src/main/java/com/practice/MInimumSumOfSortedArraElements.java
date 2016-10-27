package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MInimumSumOfSortedArraElements {
    public static void main(String[] args) {
        int a[] = { 2, 4, 5, 8, 10, 1, 9, 1, 9 };
        int sum = 10; 
        // Need to find combinations of elements in array, whose sum is equla to mentioned sum
        Set<Integer> input = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            input.add(a[i]);
        }
        allElementCombosInArrayWhoseSumIs(sum, input);
    }

    private static void allElementCombosInArrayWhoseSumIs(int sum, Set<Integer> input) {
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> itr = input.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            if (set.contains(sum - next)) {
                System.out.println("Matched group is : " + "{" + next + ", " + (sum - next) + "}");
            } else {
                set.add(next);
            }
        }
    }

}
