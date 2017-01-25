package com.practice.patterns.decorator;

/**
 * Created by shankark on 30/12/16.
 */
public class CarDecorator implements  Car{
    private Car car;

    CarDecorator(Car car) {
        this.car =car;
    }
    @Override
    public void assemble() {
        car.assemble();
        System.out.println(" In Decorator");
    }
}
