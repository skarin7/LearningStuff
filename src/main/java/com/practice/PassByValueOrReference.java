package com.practice;

import com.practice.patterns.strategy.Strategy;

/**
 * Created by shankark on 14/2/17.
 */
public class PassByValueOrReference {

    /**
     * Here for each passed a copy of the original value (if the passed is a object then its reference vale is copied)
     * and the copied valued is passed to method. what ever the operations we do here belongs to copies of the originala data.
     * @param a
     * @param b
     */
    void badSwapInJava(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
    }


    private class Point {
        String name;
        void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "[" + name + "]";
        }
    }

    void changePoint(Point point, String newValue) {
        point.setName(newValue);
    }

    int testPassNull(Integer value) {
        System.out.println("Indie test string");
     return 0;
    }

    int testPassNull(String[] value) {
        System.out.println(" Inside array");
        return 1;
    }

    public static void main(String[] args) {
        int x = 2;
        int  y = 5;
        PassByValueOrReference pass = new PassByValueOrReference();
        pass.badSwapInJava(2,5);
        Point p1 = new PassByValueOrReference().new Point();
        p1.setName("New");
        System.out.println(" Before passing value throg new reference " + p1);
        pass.changePoint(p1, "NewValue");
        System.out.println(" After passing value throg new reference " + p1);

        System.out.println(" After swapping " + " x = " + x + ", y = " + y);

//        String[] arr = null;
        pass.testPassNull((Integer) null);

        pass.testPassNull((String[]) null);

    }
}
