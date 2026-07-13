package com.cognizant.engineering.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Logger first = Logger.getInstance();
        Logger second = Logger.getInstance();
        first.log("Logger is ready");
        System.out.println("Same instance: " + (first == second));
    }
}
