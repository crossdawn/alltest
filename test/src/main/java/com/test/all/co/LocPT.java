package com.test.all.co;

import java.util.concurrent.locks.LockSupport;

public class LocPT {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (true){
                System.err.println("1");
                LockSupport.park(Thread.currentThread());
            }
        },"t1");
        Thread t2 = new Thread(()->{
            LockSupport.park(Thread.currentThread());
            while (true){
                System.err.println("2");
            }
        },"t2");
        t1.start();
        t2.start();
        LockSupport.unpark(t2);
    }
}
