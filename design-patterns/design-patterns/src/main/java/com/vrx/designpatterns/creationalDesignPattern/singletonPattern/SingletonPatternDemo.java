package com.vrx.designpatterns.creationalDesignPattern.singletonPattern;

public class SingletonPatternDemo {
    /*
     * Singleton design pattern focuses on creating a single object.
     * Same object is returned whenever the object is accessed from anywhere.
     * Used whenever we want to create a single instance of object.
     *
     * For example: For exapmle while connecting to DB, we want to create the
     * connection only one time.
     * So we can use singleton design pattern.
     */
    public static void main(String[] args) {
        System.out.println("Lazy way of creating singleton object");
        User user = User.getUser();
        System.out.println(user.hashCode());
        User user2 = User.getUser();
        System.out.println(user2.hashCode());
        if (user.hashCode() == user2.hashCode()) {
            System.out.println("Same hashcode. Singleton Object !!");
        }
        System.out.println("----------------------------");
        System.out.println("Eager way of creating singleton object");
        System.out.println(Home.getHome().hashCode());
        System.out.println(Home.getHome().hashCode());
        if (Home.getHome().hashCode() == Home.getHome().hashCode()) {
            System.out.println("Same hashcode. Singleton Object !!");
        }

    }
}
