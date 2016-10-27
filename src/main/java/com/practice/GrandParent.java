package com.practice;

public class GrandParent {

    private String name;

    public GrandParent(String name) {
        this.setName(name);
    }

    public GrandParent() {
        // TODO Auto-generated constructor stub
    }
    void sayHello() {
        System.out.println("Hello" + getName() + " I am from Grand Parent");
    }

    void testOverloading() {
        System.out.println("This is for testing overlaoding method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
