package com.practice.polymorphism;

/**
 * Created by shankark on 28/9/16.
 */
public class Child extends Parent {

    @Override
    public void display() {
        System.out.println(" From Child !!");
    }

    public void  staticBind() {
        System.out.println(" Static bind !!");
    }

  /* Here it is not overriden method as the types or argumetns changed
    @Override
    void test(Integer i, Integer b) {
        System.out.println(" Arguments order changed");
    }*/

}
