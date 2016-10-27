package com.practice.collections;

import java.util.ArrayList;
import java.util.List;

public class FailFastModificationsTest {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        for (String s : strings) {
            System.out.println(s);
            strings.add("four");
        }
    }

}
