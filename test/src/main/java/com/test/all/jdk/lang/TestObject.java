package com.test.all.jdk.lang;

import java.io.Serializable;

public class TestObject {
    public int num=0;

    public TestObject(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        System.err.println((Integer)1 instanceof Serializable);
    }
}
