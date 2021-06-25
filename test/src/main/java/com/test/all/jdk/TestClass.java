package com.test.all.jdk;

public class TestClass {
    static {
        int i =1/0;
        System.err.println("B");
    }
    static int a =getA();

    public static int getA() {
        System.err.println("A");
        return 1/0;
    }
}
