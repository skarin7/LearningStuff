package com.practice.patterns.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shankark on 26/9/16.
 */
public class AuditingProxy implements InvocationHandler {
    Object object;

    AuditingProxy(Object object) {
        this.object = object;
    }

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AuditingProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            long startTime = System.currentTimeMillis();
            result = method.invoke(object, args);
            Thread.sleep(100);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("%s took %d nano seconds", method.getName(), (endTime - startTime)));
        } catch (InvocationTargetException ite) {
            throw ite.getTargetException();
        } catch (Exception ex) {
            throw new RuntimeException("Exception while invoing object throu proxy");
        }

        return result;
    }
}
