package com.practice.patterns.decorator;

/**
 * Created by shankark on 30/12/16.
 */
public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling Basic car ");
    }
}
