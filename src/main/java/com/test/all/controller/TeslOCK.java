package com.test.all.controller;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.test.all.jdk.thread.Th;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TeslOCK {
    public static void main(String[] args) throws Exception{
//        ReentrantLock reentrantLock = new ReentrantLock(false);
//        Condition condition =reentrantLock.newCondition();
//        Thread t1 = new Thread(()->{
//            try {
//                Thread.sleep(5_000);
//                reentrantLock.lock();
//                condition.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        });
//        t1.start();
//        reentrantLock.lock();
//        t1.join();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.countDown();
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
//        cyclicBarrier.await(1,TimeUnit.SECONDS);
//        ReentrantLock reentrantLock1 = new ReentrantLock(true);
//        reentrantLock1.lock();
        Thread t1 = new Thread(()->{
            try {
                countDownLatch.await();
                System.err.println("开始工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                countDownLatch.await();
                System.err.println("开始工作");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                countDownLatch.await();
                System.err.println("开始工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(()->{
            countDownLatch.countDown();
        });
        Thread t5 = new Thread(()->{
            countDownLatch.countDown();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        t5.start();



    }
}
