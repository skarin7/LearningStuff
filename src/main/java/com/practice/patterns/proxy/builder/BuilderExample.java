package com.practice.patterns.proxy.builder;

/**
 * Created by shankark on 22/12/16.
 */
public class BuilderExample {
    public static void main(String[] args) {
        HouseBuilder aptBuilder = new ApartmentBuilder();

        HouseBuilder independentBuilder = new IndependentHouseBuilder();
        ContractorOrDirector contractorOrDirector = new ContractorOrDirector();
        contractorOrDirector.setHouseBuilder(aptBuilder);
        contractorOrDirector.ConstruvtHouse();

        contractorOrDirector.setHouseBuilder(independentBuilder);
        contractorOrDirector.ConstruvtHouse();



    }

}
