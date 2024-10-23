package com.practice;

public class TestDeadLock {

    static String r1 = "Hello";
    static String r2 = "world";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.printf("Thread 1 locking resource r2..");
                synchronized (r2) {
                    System.out.printf("Thread 1 locking resource r1..");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.printf("Thread 2 locking resource r2..");
                synchronized (r1) {
                    System.out.printf("Thread 2 locking resource r1..");
                }
            }
        });

        t1.start();
        t2.start();
    }

}
