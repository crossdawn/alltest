package com.test.all.jdk.thread;

import java.util.List;
import java.util.concurrent.locks.*;

public class Resource {
    private List list;
    private int capacity;

    private Lock lock = new ReentrantLock();
    private ReadWriteLock rwlock =  new ReentrantReadWriteLock();

    private Condition notfull =lock.newCondition();
    private Condition notempty =lock.newCondition();

    private int get()throws Exception{

        try{
            lock.lock();
            while (capacity==0){
                notempty.wait();
            }
            list.remove(1);
            notfull.signal();
        }finally {
            lock.unlock();
        }
        return 0;
    }

    private void put()throws Exception{
        try{
            lock.lock();
            while (capacity==10){
                notfull.wait();
            }
            list.remove(1);
            notempty.signal();
        }finally {
            lock.unlock();
        }
    }

}
