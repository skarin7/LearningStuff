package com.practice.patterns.proxy.aop;

/**
 * Created by shankark on 26/9/16.
 */
public class DefaultPaymentImpl  implements Payment{

    @Override
    public String toString() {
        return "DefaultPaymentImpl{}";
    }

    @Override
    public void doPayment() {
        System.out.println(" I am done with the payment");
    }
}
