package com.practice.multithreading;

/**
 * Created by shankark on 30/12/16.
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread("FirstThread~");
        mt.start();
        /**
         * In Thread term, waiting untill other thread finished execution is  called "Join"
         */
        while(mt.isAlive()) {
            Thread.currentThread().sleep(100);
        }

        mt.join();

        for (int i = 0; i < 50; i++)
            System.out.println("i = " + i + ", i * i = " + i * i);
    }
}

class MyThread extends Thread {
    String name;
    MyThread(String name) {
        super(name);
        this.name = name;
    }
    public void run() {

        System.out.println(" Executing in a separate thread :" + name);
        for (int count = 1, row = 1; row < 20; row++, count++) {

            if(count%2 == 0) {

                for (int i = 0; i < count; i++)
                    System.out.print('*');
                System.out.print('\n');
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

//        System.out.println("isAlive--" + Thread.currentThread().isAlive());
    }

}
