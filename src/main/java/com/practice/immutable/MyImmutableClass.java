package com.practice.immutable;

import java.util.HashMap;

/**
 * Created by shankark on 28/9/16.
 */
public final class MyImmutableClass {

    private String name;// immutable field
    private final int age;// Mutable field

    private final HashMap<String, String> map;// Mutable field

    /**
     * This is with Hallow copy
     * @param name
     * @param age
     * @param map
     */
/*    MyImmutableClass(String name, int age , HashMap<String, String> map) {
        this.name = name;
        this.age = age;
        this.map = map;

    }*/


    /**
     * Deep copy
     * @param name
     * @param age
     * @param map
     */
    MyImmutableClass(String name, int age , HashMap<String, String> map) {
        this.name = name;
        this.age = age;
        HashMap newMap = new HashMap();
        for (String key : map.keySet()){
            newMap.put(key, map.get(key));
        }
        this.map = newMap;
    }


    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    public HashMap getMap() {
        return (HashMap) map.clone();
    }


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("one", "1");
        map.put("two", "2");

        MyImmutableClass immutableClass = new MyImmutableClass("Shankar", 28, map);

        map.put("three", "3");


        System.out.println(" Name is " + immutableClass.getName());
        System.out.println(" Age is " + immutableClass.getAge());
        System.out.println(" map is " + immutableClass.getMap());

        System.out.println(" After changing mutable fields ");

        System.out.println(" Name is " + immutableClass.getName());
        System.out.println(" Age is " + immutableClass.getAge());
        System.out.println(" map is " + immutableClass.getMap());
    }

}
