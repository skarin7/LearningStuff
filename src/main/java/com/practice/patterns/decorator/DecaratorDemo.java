package com.practice.patterns.decorator;

import java.io.InputStreamReader;

/**
 * Created by shankark on 30/12/16.
 */
public class DecaratorDemo {
    public static void main(String[] args) {
        Car car = new CarDecorator(new LuxuryCar());
        car.assemble();
        /**
         * Here We just take the basic car then modify it to get Sports or Luxury car based on our requirement
         *Example of this pAttern is FileInputStreamReader and BuffereInputStream Reader
         *
         * We are achieving the change of state of objects at runt ime by just passing the required format. We can change the state of object by
         * using inhertitance and composition but they are compile time, we need to change the code every tiem we need to change the code.
         */
        Car sports = new CarDecorator(new SportsCar());
        sports.assemble();


        Car basicCar = new CarDecorator(new BasicCar());
        basicCar.assemble();
    }
}
