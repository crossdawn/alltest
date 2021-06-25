package com.test.all.jdk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    static InheritableThreadLocal<String> c = new InheritableThreadLocal<>();
    static ThreadLocal<String> b = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(()->{
            b.set("123");
            System.err.println(b.get());
        });
        service.execute(()->{
//            b.set("234");
            System.err.println(b.get());
        });
        service.execute(()->{
//            b.set("456");

            System.err.println(b.get());
        });
        service.execute(()->{
//            b.set("789");
            System.err.println(b.get());
        });
    }
}
