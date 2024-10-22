package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDeserialization {


    public static void main(String[] args) {

//        Employee emp = new Employee("Shankar", 27, 7765);
        GuestEmployee guest = new GuestEmployee("tester");
        guest.setName("GuestName");
        guest.setAge(124);
        guest.setRollNo(1344);
        System.out.println("Before serialization" + guest);
        FileOutputStream outStream = null;

        try {
            outStream = new FileOutputStream("sample.text");
            ObjectOutputStream objectStream = new ObjectOutputStream(outStream);
            objectStream.writeObject(guest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(outStream != null ) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }

        // Now deserialising the serialised object

        try {
            FileInputStream input = new FileInputStream("sample.text");
            ObjectInputStream objectInput = new ObjectInputStream(input);
            Employee newEmp = (GuestEmployee) objectInput.readObject();
            System.out.println("After serialzation : " + newEmp);
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
