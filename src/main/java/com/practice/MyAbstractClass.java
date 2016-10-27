package com.practice;

public abstract class MyAbstractClass implements SoftwareIndustry {

    public void anything() {
        System.out.println("For displaying anything from Abstract class !!");
    }

    @Override
    public void interface1Display() {
        System.out.println("Hello from interface1 from Abstarct class");
    }

    public abstract void internalUser();

    public abstract String getTypes();
}
