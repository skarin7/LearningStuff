package com.practice.threads;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MultiThreadExamplTest {
    public class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread1 is running !!");
            try {
                Thread.sleep(1000);
                System.out.println("Thread1 after fininshing the work");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println("Inturrupted thread1");
            }
        }
    }

    public class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread2 is running !!");
            System.out.println("Thread2 after finishing work!!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new MultiThreadExamplTest().new Thread1();
        Thread2 thread2 = new MultiThreadExamplTest().new Thread2();
        Thread.sleep(100);
        thread1.start();
        thread1.join();
        thread2.start();
        Map<String, String> map = new HashMap<>();
        map.put(null, "First null");
        map.put(null, "Latest value for null key");
        System.out.println("Printing map : " + map);
        
        Hashtable<String, String> hashTable = new Hashtable<>();
        

    }
}
