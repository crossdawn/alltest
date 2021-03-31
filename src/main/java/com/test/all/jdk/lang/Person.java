package com.test.all.jdk.lang;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private int name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
