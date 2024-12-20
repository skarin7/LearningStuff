package com.practice;

/**
 * Created by shankark on 16/2/17.
 */
public class InnerClassesTest {

    private String text = " Intialise d class";

    private class FirstInne {
        private String text = " From normal inner clas";
        SecondInne secondInne = new SecondInne();

        void print() {
//            System.out.println(" Printed text is " + text);
//            System.out.println(" Printed text is from Outer class " + InnerClassesTest.this.text);

            secondInne.print();
        }

    }

    private class SecondInne {

        void print() {
            String text = " From normal inner clas";
            System.out.println(" Printed text is " + text);
            System.out.println(" Printed text is from Outer class " + InnerClassesTest.this.text);

        }

    }

    private static class  StaticInner {

        void sampPrint() {
            String sample = "Sample..";
            System.out.println(" Hello .." + sample);
        }

    }

    public static void main(String[] args) {


        // Ststic inner class
        InnerClassesTest.StaticInner si = new InnerClassesTest.StaticInner();
        si.sampPrint();

        FirstInne normalInternal = new InnerClassesTest().new FirstInne();
        normalInternal.print();


        InnerClassesTest.StaticInner newSamp = new InnerClassesTest.StaticInner() {
            @Override
            void sampPrint() {
                System.out.println(" Overrided in Main method!!");
            }
        };

        newSamp.sampPrint();

    }
}
