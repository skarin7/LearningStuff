package com.practice;

import java.util.EnumSet;

/**
 * Created by shankark on 4/11/16.
 */
public class EnumTest {
    EnumType type;
    EnumTest(EnumType type) {
        this.type = type;
    }

    public static void main(String[] args) {
        EnumTest test = new EnumTest(EnumType.THREE);
        System.out.println(EnumSet.allOf(EnumType.class));
        System.out.println(EnumSet.of(EnumType.ONE, EnumType.THREE));
        test.printEnms();
    }

    void printEnms() {
        System.out.println(type.getValue());
    }

    public enum EnumType {
        ONE(1), TWO(2), THREE(3);

        int value;
        private EnumType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }



}
