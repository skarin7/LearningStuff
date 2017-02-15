package com.practice.collections;

import java.util.*;
import java.util.function.Consumer;

public class FailFastModificationsTest {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

/*        for (String s : strings) {
            System.out.println(s);
            strings.add("four");
        }*/
        /**
         * Another way to avoid Concurrent Modification Exception, use for-i loop
         */
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            System.out.println(strings.toArray()[i]);

            if(((String)strings.toArray()[i]).equalsIgnoreCase("one")) {
                strings.remove("one"); // Remove the element you do't need
                size--;
            }

        }
        System.out.println(" Using java8 Consumers!!");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Test

        System.out.println( " Any matches?" + strings.stream().anyMatch(p -> p.equals("two")));

        System.out.println(" Normal for -i" + strings);
        /**
         * Another one using Iterator
         */

        ListIterator<String> iter = strings.listIterator();
        while(iter.hasNext()) {
            String val = iter.next();
            if(val.equalsIgnoreCase("two")) {
                iter.remove();
            }

        }

        System.out.println("Using iterator" + strings);


    }

}
