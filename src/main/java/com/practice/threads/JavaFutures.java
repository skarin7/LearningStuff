package com.practice.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shankark on 16/2/17.
 */
public class JavaFutures {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> submit = executorService.submit(() -> {
            System.out.println(" Code from Runnable !!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" Long running query finished its work....");

        });
/*
        if(submit.isCancelled()) {
            submit.cancel(true);
            System.out.println(" Cancelled the task");
        }*/

//        submit.cancel(true);


        if(!submit.isDone()) {
            System.out.println(" Still doing the work");
            System.out.println(" Meaning while we send one more thread to do other work");

            executorService.execute(() -> System.out.println(" Small task that can be finished.."));
        } else {
            try {
                Object o = submit.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        executorService.shutdown();
    }
}
