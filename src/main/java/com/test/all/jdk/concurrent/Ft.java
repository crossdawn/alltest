package com.test.all.jdk.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Ft {
    public static void main(String[] args)throws Exception {
//        FutureTask f = (FutureTask) AsycTaskExecutor.parallelTaskExecutor.submit(()->{
//            System.err.println("sleep");
//            try {
//                TimeUnit.SECONDS.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        f.get();
        AtomicInteger a = new AtomicInteger(0);
        System.err.println(a.incrementAndGet());

        System.err.println(a.getAndIncrement());
        System.err.println(a.get());

//        a.incrementAndGet();
//        System.err.println(a.get());
        int i = 0;
        Thread t1 = new Thread(()->{
            LockSupport.park();
        });
        Thread t2 = new Thread(()->{
            LockSupport.park();
        });
        t1.start();
        t2.start();


    }
}
