package com.practice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by shankark on 16/2/17.
 */
public class CustomAnnotaionTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    private @interface checkNotNull {
        String messageToBePrinter() default "Make sure it is not null";
    }


      private static class ClassWithAnotations {
        @checkNotNull
        public void samp(String param) {
            System.out.println(" Samp" + param);
        }
    }

    class AnnotationParser {

        void parse(Class<?> clazz) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                if(m.isAnnotationPresent(checkNotNull.class)) {
                    System.out.println(" Inside Annotation parser !!");
                    checkNotNull  check = m.getAnnotation(checkNotNull.class);
                    String message = check.messageToBePrinter();
                    System.out.println(" Message passed as part of anotation is : " + message);
                    try {
                        m.invoke(ClassWithAnotations.class.newInstance(), message);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        AnnotationParser test = new CustomAnnotaionTest().new AnnotationParser();
        test.parse(ClassWithAnotations.class);

    }
}
