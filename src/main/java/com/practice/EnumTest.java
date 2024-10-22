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
        EnumTest test = new EnumTest(EnumType.ONE);
        System.out.println(EnumSet.allOf(EnumType.class));
        System.out.println(EnumSet.of(EnumType.ONE, EnumType.THREE));
        test.printEnms();

        STATUS stop = STATUS.STOP;

        System.out.println(" stop " + stop);
    }

    void printEnms() {
        System.out.println(type.getValue());
    }

    public enum EnumType {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR ("4");


        final String value;
        private EnumType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum STATUS {
        START,
        STOP,
        RESTART;
    }

}
