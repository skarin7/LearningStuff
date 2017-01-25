package com.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shankark on 30/12/16.
 */
public class NumberOfOccurences {

    public static void main(String[] args) {

        String string = "abaabcccddaabbc";
        Map<String, Long> map =
                Arrays.stream(string.split("")).
                        collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Origial map " + map);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
