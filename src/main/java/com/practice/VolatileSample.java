package com.practice;

/**
 * Created by shankark on 26/9/16.
 */
public class VolatileSample {
    static int count = 0;
    public static void main(String[] args) {

        ThreadFirst first = new ThreadFirst();
        ThreadSecond second = new ThreadSecond();

        first.start();
        second.start();
    }

    public static class ThreadFirst extends Thread {
        @Override
        public void run() {
            if(count == 0) {
                System.out.println(" Inside First Thread !!");
                count++;
            }
        }
    }

    public static class ThreadSecond extends Thread {
        @Override
        public void run() {
            if(count > 0) {
                System.out.println(" Inside Second Thread !!");
                count--;
            }
        }
    }

}
