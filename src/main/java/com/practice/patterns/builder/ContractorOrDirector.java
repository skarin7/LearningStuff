package com.practice.patterns.builder;

/**
 * Created by shankark on 22/12/16.
 */
public class ContractorOrDirector {

    HouseBuilder houseBuilder;

    public void setHouseBuilder(HouseBuilder hb) {
        this.houseBuilder = hb;
    }

    public void ConstruvtHouse() {
        //Step by step process
        houseBuilder.createNewHouse();
        houseBuilder.doHouseWiring();
        houseBuilder.doPainting();

    };
}
