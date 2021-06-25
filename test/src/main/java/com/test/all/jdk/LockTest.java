package com.test.all.jdk;

import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class LockTest {
    public static void main(String[] args) throws Exception{
        Thread.currentThread().setName("main");
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        LinkedTransferQueue arrayBlockingQueue;
//        readWriteLock.readLock().lock();
//        Lock lock = new ReentrantLock();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        PriorityQueue heap = new PriorityQueue();

        new Thread(() -> {
            try {
                try {
                    readWriteLock.readLock().lock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }finally {
            }

        },"locktest").start();
        new Thread(() -> {
            try {
                try {
                    readWriteLock.readLock().lock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }finally {
            }

        },"locktest").start();
        new Thread(() -> {
            try {
                try {
                    readWriteLock.writeLock().lock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }finally {
            }

        },"locktest").start();
        Thread.sleep(5_000);
        System.err.println("1231");
//        lock.unlock();
    }
}
