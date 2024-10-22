package com.practice.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolAsync {
    //Queue contains all the runnable or you can have WorkerTHread instances if is specific
    BlockingQueue<Runnable> queue;
    boolean isStopped = false;
    List<WorkerThread> workerThreads;
    int numOfThreads;
    ThreadPoolAsync(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.queue = new LinkedBlockingQueue<>();
        this.workerThreads = new ArrayList<>(this.numOfThreads);
        //Queue will be empy by default
        //start and Let the workers wait for the work
        for (int i = 0; i < numOfThreads; i++) {
            WorkerThread thread = new WorkerThread(queue);
            new Thread(thread).start();
        }
    }


    public synchronized void submitTask(Runnable task) throws IllegalStateException {
        if(isStopped) {
            throw new IllegalStateException("Pool is already stopped");
        }
        queue.offer(task);
    }

    public synchronized  void shutdown() {
        this.workerThreads.forEach(t -> {
            t.stop();
        });

        this.isStopped = true;
    }

    public boolean isShutdown() {
        return isStopped;
    }

    class WorkerThread implements  Runnable{
       BlockingQueue<Runnable> workQueue;
        boolean isStopped = false;
        WorkerThread(BlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    Runnable task = this.workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    // Wake up thread from sleep
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        public synchronized void stop() {
            this.isStopped = true;
            //interrupt
            Thread.currentThread().interrupt();
        }
        public synchronized boolean isStopped() {
            return isStopped;
        }
    }

    public static void main(String[] args) {
        ThreadPoolAsync poolAsync = new ThreadPoolAsync(5);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            poolAsync.submitTask(() -> {
                System.out.println("Executing task " + taskId + " by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
