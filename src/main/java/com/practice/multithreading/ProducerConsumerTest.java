package com.practice.multithreading;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ProducerConsumerTest {

    static volatile List<Integer> sharedObject = new Vector<>();

    public static void main(String[] args) {

        MyProducer prod = new MyProducer();
        MyConsumer consume = new MyConsumer();
        prod.start();
        consume.start();

    }



    static class MyProducer extends Thread {

        @Override
        public void run() {
            System.out.println("Producer producing !!");
                for (int i = 1; i < 100; i++) {
                try {
                    Thread.sleep(500);
                        sharedObject.add(i);
                        if(sharedObject.size() > 4) {
                            sharedObject.remove(sharedObject.size() - 1);
                        }

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

    }

    static class MyConsumer extends Thread {

        @Override
        public void run() {
            System.out.println("Consmer consuming!!");
            try {
                Thread.sleep(500);
                while (true) {
                    synchronized (sharedObject) {
                        Iterator<Integer> iterator = sharedObject.iterator();
                        while (iterator.hasNext()) {
                            System.out.println(iterator.next());
                        }
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            }

        }


}
