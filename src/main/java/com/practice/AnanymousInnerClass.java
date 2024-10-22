package com.practice;

public class AnanymousInnerClass {

    public static int var = 10;
    public interface SayColor {
        public void sayHello();

        void anotherHello();
    }
    public static void main(String[] args) {


        SayColor blue = new SayColor() {
            int newVar = 100;
            @Override
            public void sayHello() {
                System.out.println("Hello Blue !!" + this.newVar);
            }

            @Override
            public void anotherHello() {
//                System.out.println("I am rellay getting along!1!" + AnanymousInnerClass.this.var);
            }
        };
        blue.sayHello();
        blue.anotherHello();
    }
}
