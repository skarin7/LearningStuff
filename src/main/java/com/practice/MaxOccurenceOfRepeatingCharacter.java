package com.practice;

import java.util.HashMap;
import java.util.Map;

import static com.practice.VolatileSample.count;

/**
 * Created by shankark on 4/1/17.
 */
public class MaxOccurenceOfRepeatingCharacter {
    public static void main (String[] args) throws java.lang.Exception
    {
//        printOccurenceUsingTable();
        printOccurenceUsingMap();

    }

    private static void printOccurenceUsingTable() {
        // your code goes here
        int[] count = new int[256];
        String a = "xxyyxzzzzyyyxxxxxzzzzzzzzzzzzzz";
        int max = 0;
        for(int i=0; i<a.length(); i++){
            int index = (int)a.charAt(i);
            count[index]++;
            if(count[max] < count[index]){
                max = index;
            }
        }
        System.out.print("Maximum occurence is of " + count[max] +" times and the character is "  + (char)max);
    }

    private static void printOccurenceUsingMap() {
        // your code goes here
        Map<Character, Integer> map = new HashMap<>();
        String a = "xxyyxzzzzyyyxxxxxzzzzxxxxxxxxxxxxxxxxxzzzzzzzzzz";
        int max = 0;
        for(int i=0; i<a.length(); i++){
            char key = a.charAt(i);
            Integer count = map.get(key);
            if(count != null) {
                map.put(key, ++count);
                if(max < count) {
                    max = count;
                }

            } else {
                map.put(key, 1);
            }
        }

        System.out.print("Maximum occurence is of " + max +" times and the character is ");
        for (Map.Entry entry : map.entrySet()) {
            if(entry.getValue().equals(max)) {
                System.out.println( entry.getKey());
            }

        }

    }
}
