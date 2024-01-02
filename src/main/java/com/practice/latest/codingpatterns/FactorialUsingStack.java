package com.practice.latest.codingpatterns;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Stack;

public class FactorialUsingStack {

    static BigInteger factorial(BigInteger x) {
        if(x.intValue() ==0 || x.intValue() == 1) {
            return BigInteger.valueOf(1);
        }
        return x.multiply(factorial(x.subtract(BigInteger.valueOf(1))));
    }


    static BigInteger factorialUsingStack(BigInteger input) {
        Stack<BigInteger> tempResult = new Stack<>();
        int intValue = input.intValue();
        while (intValue > 0) {
            tempResult.push(BigInteger.valueOf(intValue));
            intValue--;
        }

        BigInteger result = BigInteger.ONE;
        while (!tempResult.isEmpty()) {
            BigInteger top = tempResult.pop();
            result = top.multiply(result);
        }
        return result;
    }

    public static void main(String[] args) {
        BigInteger x = BigInteger.valueOf(4);
        System.out.printf("Resp: " + factorial(x));
    }


    @Test
    public void testValue() {
        Assert.assertEquals(BigInteger.valueOf(120), factorial(BigInteger.valueOf(5)));
        Assert.assertEquals(BigInteger.valueOf(1), factorialUsingStack(BigInteger.valueOf(1)));
        Assert.assertEquals(BigInteger.valueOf(120), factorialUsingStack(BigInteger.valueOf(5)));
        Assert.assertEquals(BigInteger.valueOf(3628800), factorialUsingStack(BigInteger.valueOf(10)));
    }
}
