package com.test.all.co;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StateT2 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private int i;

    public StateT2( int i) {
        this.i = i;
    }
    public void put(){
        lock.lock();
        try{
            while (i>10){
                condition.await();
            }
            i++;
            System.err.println("put"+i);
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try{
            while (i<=0){
                condition.await();
            }
            i--;
            System.err.println("get"+i);
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws IOException {
        StateT2 t = new StateT2(0);
        new Thread(()->{t.put();},"t1").start();
        new Thread(()->{t.get();},"t2").start();
//        new Thread(()->{t.get();},"t3").start();
        System.in.read();
    }
}
