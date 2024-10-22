package com.practice.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shankark on 16/2/17.
 */
public class CustomThreadPool {
    BlockingQueue<Runnable> ques = null;
    ThreadWorrker[] workers = null;
    CustomThreadPool(int noOfThreads, int thredsInQueue) {
         this.workers = new ThreadWorrker[noOfThreads];// For number of threads
         this. ques = new LinkedBlockingQueue<Runnable>();
        for (int i = 0; i < noOfThreads; i++) {
            workers[i] = new ThreadWorrker();
            workers[i].start();
        }
    }

    volatile boolean isStopped = false;

    public void execute(Runnable runnable) throws InterruptedException {
        synchronized (ques) {
            if (isStopped) {
                throw new InterruptedException(" Thread is interrupted");
            }
            this.ques.add(runnable);
            ques.notifyAll();
        }
    }

    public void stopThePool() {
        this.isStopped = true;

        while (!ques.isEmpty()) {
            System.out.println(" Waiting for other threda to complete....");
        }
        for (int i = 0; i < workers.length; i++) {
               workers[i].stopThisThread();
        }

    }


   private class ThreadWorrker extends Thread {
//        BlockingQueue<Runnable> queue = null;
        private  volatile boolean stoppedInsideThread = false;
        @Override
        public void run() {
            while (!stoppedInsideThread) {
                synchronized (ques) {
                    while (ques.isEmpty()) {
                        try {
                            ques.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Runnable runnable = ques.poll();
                    runnable.run();

                }

            }

        }

        public synchronized void stopThisThread() {
            this.stoppedInsideThread = true;
            this.interrupt();
        }


        public synchronized boolean isStopped() {
            return stoppedInsideThread;
        }


    }

    public static void main(String[] args) {
        CustomThreadPool cust = new CustomThreadPool(4, 3);

        Runnable t1 = () -> System.out.println(" Run thread t1");

        Runnable t2 = () -> System.out.println(" Run thread t2");

        try {
            cust.execute(t1);
//            cust.execute(t2);
            cust.stopThePool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
