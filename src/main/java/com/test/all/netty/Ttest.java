package com.test.all.netty;

import java.util.concurrent.atomic.AtomicInteger;

public class Ttest {
    private static Integer a = 0;
    private static AtomicInteger aa=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{add();});
        Thread t2 = new Thread(()->{add();});
        Thread t3 = new Thread(()->{add();});
        Thread t4 =  new Thread(()->{add();});
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.err.println(aa.get());

    }
    private  static void add()  {
        while (aa.get()<100){
            try {
                Thread.sleep(5);
                aa.compareAndSet(aa.get(),aa.get()+1);
            }catch (Exception e){}
        }

    }
}
