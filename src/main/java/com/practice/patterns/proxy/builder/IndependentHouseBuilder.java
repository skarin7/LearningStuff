package com.practice.patterns.proxy.builder;

/**
 * Created by shankark on 22/12/16.
 */
public class IndependentHouseBuilder extends HouseBuilder {


    @Override
    void doHouseWiring() {
        System.out.println(" Wiring for Independent House");
    }

    @Override
    void doPainting() {
        System.out.println(" Painting for Independent House");
    }
}
