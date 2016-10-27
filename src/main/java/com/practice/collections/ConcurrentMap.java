package com.practice.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentMap {

    public static int genRandom(int min, int max) {
        Random rand = new Random();
        return min + rand.nextInt(max - min + 1);
    }
    public static void main(String[] args) {
        Map<String, String> test = new ConcurrentHashMap<>();
        test.put("one", "1");
        test.putIfAbsent("one", "111");
        test.putIfAbsent("two", "22");
        System.out.println(test);
        for (int i = 0; i < 10; i++) {
            System.out.println(ConcurrentMap.genRandom(2, 10));
        }

        for (Entry<String, String> iterator : test.entrySet()) {
            System.out.println(iterator.getKey() + " " + iterator.getValue());
        }

        List<String> str = new ArrayList<>();
        str.add("sam");
        str.add("samp");
        str.add("sample");
        Iterator<String> iterator = str.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // str.add("sample1"); ConcurrentModException
        }
        ListIterator<String> listIterator = str.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.next());
        }

        List<String> copyOnarray = new CopyOnWriteArrayList<>();
        copyOnarray.add("sam");
        copyOnarray.add("samp");
        copyOnarray.add("sample");
        Iterator<String> itr = copyOnarray.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            copyOnarray.add("sample1");
        }

        Set<String> sets = new CopyOnWriteArraySet<>();
        sets.add(null);
        sets.add(null);
        sets.add("Hello");
        System.out.println("Sets : " + sets);

        Collection<String> synchronizedCollection = Collections.synchronizedCollection(sets);
    }

}
