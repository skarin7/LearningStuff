package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FunctionalInterfaceJava8Demo {
    public int var = 10;
    @FunctionalInterface
    public interface Demofunction {
        Integer testSomething(Integer val);
    }

    Demofunction testReturntype() {
        return (x) -> x + 100;
    }

    void doSomething(int y) {
        Demofunction sampTest = (x) -> {
            return x + y + this.var;
        };
        List<Integer> asList = Arrays.asList(1, 2, 3, 4);
        asList.forEach(x -> System.out.println(sampTest.testSomething(x + var)));
    }

    public static void main(String[] args) {
        BiConsumer<Integer, String> test = (x, y) -> {
            System.out.println(x + y);
        };
        int y = 100;
        FunctionalInterfaceJava8Demo demo = new FunctionalInterfaceJava8Demo();
        demo.doSomething(y);
        
        Function<Integer, Integer> addSomething = (x) -> {
            System.out.println(x + 10);
            return x + 10;
        };

        System.out.println("After Function : " + addSomething.apply(10));
        List<Integer> asList = Arrays.asList(1, 2, 3, 4);
        asList.forEach(x -> addSomething.apply(x));
    }

}
