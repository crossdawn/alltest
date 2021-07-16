package com.test.all.co;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class SycT {
    public static void main(String[] args) throws Exception {
        Object lock = new Object();
        AtomicInteger i= new AtomicInteger();
        new Thread(() -> {
            while (true){
                synchronized (lock){

//                    if (i.get() ==0){
//                        try {
////                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t1").start();
        new Thread(() -> {
            synchronized (lock){
                while (i.get() ==0){
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                //                while (i.get() ==0){
//                    try {
////                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }, "t2").start();

        new Thread(()->{
            try {
                synchronized (lock){
//                    i.getAndIncrement();
                    lock.notify();
                }
                LockSupport.park();
                Thread.sleep(10_000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t3").start();

        System.in.read();
    }
}
