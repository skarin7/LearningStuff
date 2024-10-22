package com.practice.multithreading;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by shankark on 1/2/17.
 */
public class PrintEvenOddMultipleThreads {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);numbers.add(6);numbers.add(7);




        CalcThread[] threads = new CalcThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new CalcThread(numbers);
            threads[i].start();
/*            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }

    static class CalcThread extends Thread {
        private CopyOnWriteArrayList<Integer> array;
        CalcThread(CopyOnWriteArrayList<Integer> values) {
            this.array = values;
        }

        @Override
        public void run() {
            synchronized (array) {
                array.forEach( p -> {
                    if(p%2 ==0) {
                        System.out.println(p);
//                        array.remove(p);
/*                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    } else {
//                    array.add(p);
                    }

                });
            }
            }

    }
}
