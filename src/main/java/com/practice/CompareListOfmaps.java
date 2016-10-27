package com.practice;

import java.util.*;

/**
 * Created by shankark on 13/10/16.
 */
public class CompareListOfmaps {


    public static void main(String[] args) {
        List<Map<Integer, String>> lofmp1 = new ArrayList<>();
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "one");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(2, "two");
        lofmp1.add(map1);
        lofmp1.add(map2);
        List<Map<Integer, String>> lofmp2 = new ArrayList<>();
        Map<Integer, String> map21 = new HashMap<>();
        map21.put(1, "one");
        Map<Integer, String> map22 = new HashMap<>();
        map22.put(2, "two");
        lofmp2.add(map21);
        lofmp2.add(map22);
        System.out.println(" IsEquals : " + compareListOfMaps(lofmp1, lofmp2));


    }

    private static boolean compareListOfMaps(List<Map<Integer, String>> lofmp1, List<Map<Integer, String>> lofmp2) {
        ListIterator<Map<Integer, String>> list1Itr1 = lofmp1.listIterator();
        ListIterator<Map<Integer, String>> list1Itr2 = lofmp2.listIterator();
        while(list1Itr1.hasNext() && list1Itr2.hasNext()) {
            Map<Integer, String> next1 = list1Itr1.next();
            Map<Integer, String> next2 = list1Itr2.next();
            Set<String> values1 = new HashSet<>(next1.values());
            Set<String> values2 = new HashSet<>(next2.values());
            if(!values1.equals(values2)) {
                return false;

            }
        }

        return true;
    }


}
