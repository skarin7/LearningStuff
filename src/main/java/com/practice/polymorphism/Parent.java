package com.practice.polymorphism;

/**
 * Created by shankark on 28/9/16.
 */
public class Parent {

    public void display() {
        System.out.println(" Hello there ! I am from Parent");
    }

    void staticBinding() {
        System.out.println(" Static bindng at the compilation time ");
    }

    void test(String s, Integer i) {
        System.out.println(" Testing method 1");
    }

    /**
     * Order of arguments are also method overloading !!
     * @param i
     * @param s
     */
    void test(Integer i, String s) {
        System.out.println(" Arguments order changed");
    }

    @Override
    public String toString() {
        return "Parent{}";
    }
}
