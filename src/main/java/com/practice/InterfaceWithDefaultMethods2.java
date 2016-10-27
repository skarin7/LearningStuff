package com.practice;

public interface InterfaceWithDefaultMethods2 {

    default int increment(int y) {
        System.out.println("I am from Interace 2");
        return y + 10;
    }
}
