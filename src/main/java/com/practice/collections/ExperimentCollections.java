package com.practice.collections;

import java.util.*;

public class ExperimentCollections {

    public static void main(String[] args) {
        List<String> llist = new ArrayList<>();
        llist.add("c");
        llist.add("a");
        llist.add("b");

        ListIterator iterator = llist.listIterator();

        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            if (next.equalsIgnoreCase("a")) {
                iterator.set("abc");
                iterator.add("new");
            } else if (next.equalsIgnoreCase("b")) {
                iterator.remove();
            }
        }


        System.out.println(llist);
/*        System.out.println(llist);
        Collections.sort(llist);
        System.out.println(llist);
        List<String> array = new ArrayList<>(4);
        array.add("Threee");
        System.out.println(array.get(0));
        List<String> stringList = new ArrayList<String>(){{add("one"); add("two");}};
        System.out.println(stringList);*/


    }

}
