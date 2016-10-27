package com.practice.patterns.proxy.aop;

/**
 * Created by shankark on 26/9/16.
 */
public class ProxyTester {
    public static void main(String[] args) {
        Payment payment = (Payment) AuditingProxy.newInstance(new DefaultPaymentImpl());
        payment.doPayment();
    }
}
