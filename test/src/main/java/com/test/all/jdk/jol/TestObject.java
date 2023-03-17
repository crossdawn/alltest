package com.test.all.jdk.jol;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestObject {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        System.err.println(ClassLayout.parseInstance(executorService).toPrintable());
    }
}
