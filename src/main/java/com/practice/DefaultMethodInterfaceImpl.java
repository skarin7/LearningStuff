package com.practice;

public class DefaultMethodInterfaceImpl implements InterfaceWithDefaultMethods1, InterfaceWithDefaultMethods2 {

    public static void main(String[] args) {
        DefaultMethodInterfaceImpl test = new DefaultMethodInterfaceImpl();
        System.out.println(test.increment(5));
    }

    @Override
    public int increment(int x) {
        // TODO Auto-generated method stub
        return InterfaceWithDefaultMethods1.super.increment(x);
    }


}
