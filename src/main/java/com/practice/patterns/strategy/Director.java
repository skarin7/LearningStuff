package com.practice.patterns.strategy;

/**
 * Created by shankark on 24/1/17.
 */
public class Director {
    public static void main(String[] args) {
        Context context = new Context(new AddOperation());
        context.execute(2, 5);

        Context subContext = new Context(new SubtractOperation());
        subContext.execute(5, 2);
    }
}
