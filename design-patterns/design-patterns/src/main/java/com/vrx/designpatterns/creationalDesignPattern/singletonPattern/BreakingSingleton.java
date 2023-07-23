package com.vrx.designpatterns.creationalDesignPattern.singletonPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakingSingleton {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException,
            IOException, ClassNotFoundException {
        // ----------------------------------------------
        // Methods to break Singleton Design Pattern
        // ----------------------------------------------
        // 1. Reflection API
        User user = User.getUser(); // 1st object
        System.out.println(user.hashCode());
        Constructor<User> constructor = User.class.getDeclaredConstructor();
        constructor.setAccessible(true); // making private constructor accessible, thus breaking
        User user2 = constructor.newInstance(); // 2nd object
        System.out.println(user2.hashCode());
        if (user.hashCode() == user2.hashCode()) {
            System.out.println("Singleton Exists");
        } else {
            System.out.println("Singleton broken");
        }

        // Solution 1: if object is there, throw exception from inside constructor

        // System.out.println();
        // System.out
        // .println("After implementing solution 1: THROWING EXCEPTION FROM
        // CONSTRUCTOR");
        // Constructor<ResolvingBreakage> constructor1 =
        // ResolvingBreakage.class.getDeclaredConstructor();
        // constructor1.setAccessible(true);
        // ResolvingBreakage object = constructor1.newInstance(); // throws exception
        // while creating object
        // System.out.println(object.hashCode());

        // Solution 2: USE ENUM

        // System.out.println();
        // Colors colors = Colors.INSTANCE; // Creating ENUM class object
        // System.out.println(colors.hashCode());
        // colors.test(); // Calling method from created object of ENUM class
        // System.out
        // .println("After implementing solution 2: 'USING ENUM'");
        // Constructor<Colors> constructor1 = Colors.class.getDeclaredConstructor();
        // constructor1.setAccessible(true);
        // Colors object = constructor1.newInstance();
        // System.out.println(object.hashCode());

        // ----------------------------------------------------------------
        // 2. Deserialization : Serialize and deserialize

        System.out.println();
        ObjectOutputStream serialize = new ObjectOutputStream(new FileOutputStream("test.ob"));
        serialize.writeObject(user);
        System.out.println("serialization done...");
        ObjectInputStream deserialize = new ObjectInputStream(new FileInputStream("test.ob"));
        User usr = (User) deserialize.readObject();
        System.out.println("deserialization done...");
        // above code breaks singleton pattern
        System.out.println(user.getUser().hashCode());
        System.out.println(usr.hashCode());

        // Solution 1: implement readResolve() method in User.java
        // gives same object even after deserialization

    }
}
