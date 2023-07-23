package com.vrx.designpatterns.creationalDesignPattern.singletonPattern;

import java.io.Serializable;

public class User implements Serializable {

    private static User user;

    // make the constructor private so that it can't be called directly
    private User() {

    }

    // LAZY WAY - of creating singleton object
    // public - which can be called to create object of this class
    // static - to create object at class load time
    public static User getUser() {
        // for implementing thread safety
        if (user == null) { // threads will not have to wait for other threads till they release the
                            // synchronized block, if object is already created
            synchronized (User.class) { // ensures single object is created in multithreaded environment
                if (user == null) { // checks that object should not pe present previously
                    user = new User();
                }
            }
        }

        return user;
    }

    public Object readResolve() {
        return user;
    }
}
