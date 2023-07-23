package com.vrx.designpatterns.creationalDesignPattern.singletonPattern;

public class Home {

    // EAGER WAY - of creating object
    private static Home home = new Home();

    private Home() {
    }

    public static Home getHome() {
        return home;
    }
}
