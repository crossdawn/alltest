package com.test.all.co;

import java.io.IOException;

public class StateT {
    private Object lock;
    private int i;

    public StateT(Object lock, int i) {
        this.lock = lock;
        this.i = i;
    }

    public void get(){
        synchronized (lock){
            try {
                while (i<=0){
                    Thread.sleep(10_000);
                    System.err.println(Thread.currentThread().getName()+"wait");
                    lock.wait();
                }
                i--;
                System.err.println(Thread.currentThread().getName()+"get"+i);
                lock.notify();
            }catch (Exception e){

            }

        }
    }

    public void put(){
        synchronized (lock){
            try {
                while (i>=5){
                    System.err.println(Thread.currentThread().getName()+"wait");
                    lock.wait();
                }
                i++;
                System.err.println(Thread.currentThread().getName()+"put"+i);
                lock.notify();
            }catch (Exception e){

            }

        }
    }

    public static void main(String[] args) throws IOException {
        Object lock = new Object();
        StateT t = new StateT(lock,0);
        new Thread(() -> {
//            while (true) {
                t.get();
//            }
        },"t1").start();
        new Thread(() -> {
//            while (true) {
                t.put();
//            }
        },"t2").start();
        new Thread(() -> {
//            while (true) {
            t.put();
//            }
        },"t3").start();
        System.in.read();
    }
}
