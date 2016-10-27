package com.practice.patterns.proxy;

/**
 * Created by shankark on 26/9/16.
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image proxy = new ProxyImage("admin", "Hello.jsp");
        proxy.checkPermissionsAndDisplay();

       // proxy.checkPermissionsAndDisplay();// It loads the Real object only when needed

    }
}
