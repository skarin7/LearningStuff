package com.practice;

public class TestInherit {
    void overload() {
        System.out.println("Inside overlaod empty");
    }

    void overload(int x) throws Exception {
        System.out.println("Inside overlaod parameter");
    }
    public static void main(String[] args) {

        GrandParent child = new Parent("parent1");
        child.sayHello();
        Parent parent = new Child();
        parent.sayHello(6);

        TestInherit inherit = new TestInherit();
        inherit.overload();


    }

}
