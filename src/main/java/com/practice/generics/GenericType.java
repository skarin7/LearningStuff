package com.practice.generics;

import java.util.*;

/**
 * Created by shankark on 29/9/16.
 */
public class GenericType<T extends Number> {
    T t;

    public T get() {
       return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static <T extends Number> boolean isEquals(GenericType<T> g1, GenericType<T> g2) {
        return  g1.get().equals(g2.get());
    }

    public  static double sum(List<? extends Number> list) {
        int sum = 0;
        for(Number item: list) {
            sum+= item.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        GenericType genericType = new GenericType();
        genericType.set(50);
        genericType.set(12);// We can pass anytype
        genericType.set(new Integer(2));
        System.out.println(genericType.get());
        GenericType<Integer> stringGenericType = new GenericType<>();
        stringGenericType.set(6);

        Object o = new GenericType<Integer>();
        GenericType<Integer> intGenericType = new GenericType<>();
        intGenericType.set(12);
        boolean equals = GenericType.isEquals(stringGenericType, intGenericType);
        System.out.println("isEquals: " + equals);

        List list = new ArrayList<>();
        list.add(14.0);
        list.add(34);

        System.out.println(GenericType.sum(list));
    }
}
