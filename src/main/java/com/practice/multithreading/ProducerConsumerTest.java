package com.practice.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProducerConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> sharedObject = new ArrayList<>();
        Object lock = new Object(); // Shared lock object for synchronization

        MyProducer prod = new MyProducer(sharedObject, 5, lock);
        Thread producerThread = new Thread(prod);

        MyConsumer consume = new MyConsumer(sharedObject, 5, lock);
        Thread consumerThread = new Thread(consume);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }

    static class MyProducer implements Runnable {
        final List<Integer> sharedObject;
        int maxSize;
        final Object lock;

        public MyProducer(List<Integer> sharedObject, int maxSize, Object lock) {
            this.sharedObject = sharedObject;
            this.maxSize = maxSize;
            this.lock = lock;
        }

        @Override
        public void run() {
            System.out.println("Producer producing !!");

            while (true) {
                synchronized (lock) {
                    // Wait if buffer is full
                    while (sharedObject.size() == maxSize) {
                        System.out.println("Buffer is full, waiting...");
                        try {
                            lock.wait(); // Wait until consumer consumes items
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // Produce items if buffer is not full
                    for (int i = 0; i < maxSize; i++) {
                        sharedObject.add(i);
                        System.out.println("Produced: " + i);
                    }

                    // Notify the consumer that items are ready
                    System.out.println("Buffer is full, notifying consumer...");
                    lock.notify();

                    try {
                        // Simulate time taken to produce
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    static class MyConsumer implements Runnable {
        final List<Integer> sharedObject;
        int maxSize;
        final Object lock;

        public MyConsumer(List<Integer> sharedObject, int maxSize, Object lock) {
            this.sharedObject = sharedObject;
            this.maxSize = maxSize;
            this.lock = lock;
        }

        @Override
        public void run() {
            System.out.println("Consumer consuming!!");

            while (true) {
                synchronized (lock) {
                    // Wait if buffer is empty
                    while (sharedObject.isEmpty()) {
                        System.out.println("Buffer is empty, waiting...");
                        try {
                            lock.wait(); // Wait until producer produces items
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // Consume items if buffer is not empty
                    Iterator<Integer> iterator = sharedObject.iterator();
                    while (iterator.hasNext()) {
                        Integer item = iterator.next();
                        System.out.println("Consumed: " + item);
                    }

                    try {
                        System.out.println(" Consuming all the events.. and take rest for sometime before asking prodcuer to producer");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // Clear the buffer
                    sharedObject.clear();
                    System.out.println("Buffer is empty, notifying producer...");

                    // Notify the producer that buffer is empty and they can produce
                    lock.notify();

                    try {
                        // Simulate time taken to consume
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
