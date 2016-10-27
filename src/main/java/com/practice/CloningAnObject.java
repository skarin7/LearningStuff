package com.practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CloningAnObject {

    public CloningAnObject() {

    }

    public static class SafeSimpleDateFormat {
        private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyyMMdd HHmm");
            };
        };

        public String getFormatterDate(Date date) {
            return formatter.get().format(date);
        }
    }

    public SafeSimpleDateFormat getSafeSDF() {
        return new SafeSimpleDateFormat();
    }

    public void test() {
        System.out.println("Printing test");
    }


    public static void main(String[] args) {
        Employee orig = new Employee("shankar", 28, 7765);
        if (orig instanceof Employee) {
            System.out.println("This implements Cloneable");
            Employee clone = (Employee) orig.clone();
            System.out.println(clone);
            System.out.println(orig.equals(clone));
            clone.setAge(30);
        }

        System.out.println(orig.getAge());

        try {
            Class<?> thisClass = String.class.forName("com.practice.CloningAnObject");
            System.out.println(thisClass);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CloningAnObject test = new CloningAnObject();
        
        System.out.println(test.getSafeSDF().getFormatterDate(new Date()));
        
        Runnable task1 = () -> {
            System.out.println("Inside thread " + Thread.currentThread().getName());
        };
        Runnable task2 = () -> {
            System.out.println("Inside thread " + Thread.currentThread().getName());
        };
        new Thread(task1).start();
        new Thread(task2).start();
        // Wont allow null - key/value in Hashtable
/*        Hashtable<String, String> tab = new Hashtable<>();
        tab.put(null, null);
        tab.get(null);
*/
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, "2");
        System.out.println(map);
    }
    // Can overload main method but will not be triggered by JVM
    public static void main(String[] args, String test) {

    }

}
