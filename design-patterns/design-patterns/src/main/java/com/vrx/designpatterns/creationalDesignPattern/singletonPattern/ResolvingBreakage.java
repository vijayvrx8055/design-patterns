package com.vrx.designpatterns.creationalDesignPattern.singletonPattern;

public class ResolvingBreakage {

    private static ResolvingBreakage object;

    private ResolvingBreakage() {
        // resolving breakage by adding check for existing object
        if (object == null) {
            throw new RuntimeException("Singleton - object already exists.");
        }
    }

    public static ResolvingBreakage getResolvingBreakage() {
        if (object == null) {
            synchronized (ResolvingBreakage.class) {
                if (object == null) {
                    object = new ResolvingBreakage();
                }
            }
        }

        return object;

    }
}
