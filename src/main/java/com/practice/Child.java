package com.practice;

class Child extends Parent {

    public Child(String name) {
        super(name);
    }

    public Child() {
        System.out.println("Child class constructor");
    }

    @Override
    void sayHello() {
        System.out.println("Hello" + super.getName() + " I am from Child");
    }


    @Override
    public Integer test() {
        return 1;
    }

}
