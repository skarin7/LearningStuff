package com.practice.patterns.proxy.builder;

/**
 * Created by shankark on 22/12/16.
 */
public abstract class HouseBuilder {

    protected House house;

    protected House createNewHouse() {
        return new House();
    }

    abstract void doHouseWiring();
    abstract void doPainting();

}
