package com.practice;

/**
 * Created by shankark on 27/9/16.
 */
public class MultipleInheritanceExample {

    public static void main(String[] args) {
        AB ab = new AB();
        ab.print();
        ab.usePrint();

    }

    public interface A {
        void print();
    }

    public static class B {
        public void print() {
            System.out.println(" From class B");
        }
    }

    public static class AB extends B implements A {


        void usePrint() {
            ((A) () -> System.out.println(" From inside interface A")).print();
        }

        @Override
        public void print() {
            System.out.println(" Inside AB");
        }


    }

}
