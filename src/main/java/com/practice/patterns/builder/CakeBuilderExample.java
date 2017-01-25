package com.practice.patterns.builder;

/**
 * Created by shankark on 22/12/16.
 */
public class CakeBuilderExample {

    public static void main(String[] args) {

        Cake cake = new Cake.CakeBuilder(1, "Mandatory cream").setDryFruits("Dry").build();

        System.out.println(cake);

//        Queue q = new LinkedList<>();


//        ConcurrentHashMap
    }
}
