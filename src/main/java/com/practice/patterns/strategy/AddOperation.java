package com.practice.patterns.strategy;

/**
 * Created by shankark on 24/1/17.
 */
public class AddOperation implements Strategy {
    @Override
    public void doOperation(int x, int y) {
        System.out.println(" Sum is " + (x+ y));
    }
}
