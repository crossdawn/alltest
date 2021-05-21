package com.test.all.jdk;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) throws Exception {
        AtomicInteger a = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            while (incr(a)) {

            }
        }, "A");
        t1.start();
        Thread t2 = new Thread(() -> {
            while (incr(a)) {

            }        }, "B");
        t2.start();
        Thread t3 = new Thread(() -> {
            while (incr(a)) {

            }        }, "C");
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.err.println(a.get());

    }

    private static boolean incr(AtomicInteger a) {
//        try{
//            Thread.sleep(10);
//
//        }catch (Exception e){}
        int i = a.get();
        if (i >= 200) {
            return false;
        }
        if (a.compareAndSet(i, i + 1)) {
           System.out.println(Thread.currentThread().getName() + "成功+1");
            return true;
        }
        System.err.println(Thread.currentThread().getName() + "重试");
        return incr(a);
    }
}
