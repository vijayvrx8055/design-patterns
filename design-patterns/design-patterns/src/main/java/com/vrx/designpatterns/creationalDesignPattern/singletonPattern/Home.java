package com.vrx.designpatterns.creationalDesignPattern.singletonPattern;

public class Home implements Cloneable {

    // EAGER WAY - of creating object
    private static Home home = new Home();

    private Home() {
    }

    public static Home getHome() {
        return home;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();
        return home; // returning same class instance to avoid multiple objects
    }
}
