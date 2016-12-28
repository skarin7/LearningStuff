package com.practice.patterns.proxy.builder;

/**
 * Created by shankark on 22/12/16.
 */
public class ApartmentBuilder extends HouseBuilder {


    @Override
    void doHouseWiring() {
        System.out.println(" Adding wiring for Apartments");
    }

    @Override
    void doPainting() {
        System.out.println(" Painting for Apartments");
    }
}
