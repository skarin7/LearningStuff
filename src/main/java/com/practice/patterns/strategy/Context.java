package com.practice.patterns.strategy;

/**
 * Created by shankark on 24/1/17.
 */
public class Context {
    Strategy starategy;

    Context(Strategy starategy) {
        this.starategy = starategy;
    }

    void execute(int x, int y) {
        starategy.doOperation(x, y);
    }
}
