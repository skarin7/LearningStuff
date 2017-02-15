package com.practice.polymorphism;

/**
 * Created by shankark on 28/9/16.
 */
public class TestPloymorphism {

    /**
     * This is Dynamic binding . At the compilation time Compiler will bind the parent object's display method for compilation validation
     * Whre as Parent p = new Child(), here the child object reference is resolved at runtime to the overriden method
     * @param args
     */
    public static void main(String[] args) {
        Parent parent = new Parent();

        parent.display();
        parent.staticBinding();

        parent.test(1, "hello");
        parent.test("hello", 2);

        Child child = new Child();
        child.display();



    }
}
