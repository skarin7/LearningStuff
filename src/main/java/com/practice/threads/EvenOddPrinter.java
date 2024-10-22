package com.practice.threads;

/**
 * Created by shankark on 16/2/17.
 */
public class EvenOddPrinter extends Thread {
    Object lock;
    int numbers;
    String name;
    volatile static int i = 1;
    private volatile boolean isStopped = false;

    EvenOddPrinter(String name, int n, Object lock) {
        this.numbers = n;
        this.lock = lock;
        this.setName(name);
    }

    @Override
    public void run() {
//        System.out.println(" Inside thread .." + " Its name is : " + Thread.currentThread().getName() + " and i here is : " + i);

            while (i <= 10 && !isStopped) {
                if (i % 2 == 0 /*&& Thread.currentThread().getName().equalsIgnoreCase(name)*/) {
//                System.out.println(" Waitin g for odd thread to compleet ..");
                    synchronized (lock) {
                        System.out.println("Even: " + i);
                        i++;
                        try {
                            lock.wait(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
                if (i % 2 == 1) {
//                System.out.println(" Waitin g for even thread to compleet ..");
                    synchronized (lock) {
                        System.out.println("Odd: " + i);
                        lock.notify();
                        i++;
                    }

                }
            }


    }

    public synchronized void stopTheThread() {
        this.isStopped = true;
        this.interrupt();
    }


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        EvenOddPrinter even = new EvenOddPrinter("Even", 10, lock);
        EvenOddPrinter odd = new EvenOddPrinter("Odd", 10, lock);

        even.start();
        odd.start();
/*
        even.join();
        odd.join();*/


        if(!even.isAlive() && !odd.isAlive()) {
            even.stopTheThread();
            odd.stopTheThread();
        }

    }


}
