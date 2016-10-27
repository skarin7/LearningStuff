package com.practice;

public class Parent extends GrandParent {
    private String testAccess;
    public Parent(String name) {
        super(name);
    }

    public Parent() {
    }

    @Override
    void sayHello() {
        System.out.println("Hello" + super.getName() + " I am from Parent");
    }

    void sayHello(int x) {
        System.out.println("This is method overloading child class" + super.getName());
    }

    protected Integer test() {
        System.out.println("It is parent class, access specifier test");
        return 1;
    }
}
