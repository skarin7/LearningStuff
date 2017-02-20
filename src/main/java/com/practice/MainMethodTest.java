package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shankark on 27/10/16.
 */
public class MainMethodTest {
    public static void main(String[] args) {
        String[] vals = {"One", "Two", "Four"};
        main(vals, "yes");

        List<String> stringList = Arrays.asList(vals);

        List<String> collect = stringList.stream().
                map((String x) -> {
                    return x + "_new";
                }).collect(Collectors.toCollection(ArrayList::new));
//        stringList.stream().reduce(x-> x.equalsIgnoreCase("One"));
        System.out.println(collect);
    }

    public static void main(String[] args, String overidden) {
        System.out.println("values are: " + Arrays.toString(args) + " overiiden" + overidden);
    }
}
