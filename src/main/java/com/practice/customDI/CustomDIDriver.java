package com.practice.customDI;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;

public class CustomDIDriver {

    @Inject
    CustomDIDriver() {

    }

    interface MessageService {
        void sendMessage(String message);
    }

    /**
     * If you don't make inner classes as static, object creation would break as reflection adds the parent constructor as part of
     *
     * constructor.getParameterTypes()
     */
    @Singleton
    static class EmailService implements MessageService {
        public void sendMessage(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    static class UserService {
        private final MessageService messageService;

        @Inject
        public UserService(MessageService messageService) {
            this.messageService = messageService;
        }

        public void notifyUser(String message) {
            messageService.sendMessage(message);
        }
    }

    static class HelloThere {
        String name = "default";
        @Inject
        HelloThere(String name) {
            this.name= name;
        }

        public void display (String temp) {
            System.out.println(" Hello" + temp);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        CustomDI diContainer = new CustomDI();
        diContainer.bind(MessageService.class, EmailService.class);
/*        HelloThere userService = diContainer.getInstance(HelloThere.class);
        userService.display(" Hello there !!");*/

        UserService userService = diContainer.getInstance(UserService.class);
        userService.notifyUser(" Hello there !!");


 /*       String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(File.pathSeparator);

*/
        //inner classes are $ separated for accessign through reflecting
        Class<?> custJdDriver = Class.forName("com.practice.customDI.CustomDIDriver$UserService");

        System.out.println(" Name the file" + custJdDriver.getName());
        ClassLoader classLoader = CustomDIDriver.class.getClassLoader();
//        System.out.println( "loaded file " + classLoader.getResource("customJD.class"));

        System.out.println( "class " + classLoader.getClass());
        System.out.println("classLoader name"  + classLoader.toString());
        System.out.println( "abs path" + new File(".").getAbsolutePath());


/*
        for (String classpathEntry : classpathEntries) {
            System.out.println(classpathEntry + " ");
        }
*/

/*        Class<?> myclass = Class.forName("WordBreak.class");
        System.out.println(" Get the class anem" + myclass.getName());*/
    }
}
