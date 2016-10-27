package com.practice;

public interface InterfaceWithDefaultMethods1 {

    default int increment(int x) {
        System.out.println("I am from Interace 1");
        x = x + 5;
        return x;
    }

    default void log() {
        System.out.println("Logging utility method");
    }

    default String trimTheStrings(String data) {
        return data.trim();
    }
}
