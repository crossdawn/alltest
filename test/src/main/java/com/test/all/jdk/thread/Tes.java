package com.test.all.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Tes {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("threadLocal主线程的值");
        Thread.sleep(100);
        new Thread(() -> System.out.println("子线程获取threadLocal的主线程值：" + threadLocal.get())).start();
        Thread.sleep(100);
        inheritableThreadLocal.set("inheritableThreadLocal主线程的值");
        System.err.println("父线程"+inheritableThreadLocal.get());
        inheritableThreadLocal.remove();
        new Thread(() -> System.out.println("子线程获取inheritableThreadLocal的主线程值：" + inheritableThreadLocal.get())).start();
        AtomicInteger a = new AtomicInteger(Integer.MIN_VALUE);
        int index = a.getAndIncrement();
        System.err.println(index);
        if (index < 0) {
            a.decrementAndGet();
            System.err.println(a.get());
            throw new IllegalStateException("Too many thread-local indexed variables");
        }
    }
}
