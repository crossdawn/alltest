package com.test.all.co;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConT {
    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        AtomicInteger i = new AtomicInteger();
        new Thread(() -> {
            lock.lock();
            while (i.get() ==0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100_0000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "t1").start();
        new Thread(() -> {
            lock.lock();
            while (i.get() ==0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }, "t2").start();

        new Thread(()->{
            try {

                    lock.lock();
                    i.getAndDecrement();
                    condition.signalAll();
                    lock.unlock();

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t3").start();

        System.in.read();
    }
}
