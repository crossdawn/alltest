package com.test.all.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberAdd {
    private static AtomicInteger num =new AtomicInteger();

    private  static void add(){
        if (num.get()<100){
            System.err.println("线程1:"+num.incrementAndGet());
        }
    }
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()-> {

            while (num.get()<100){
                add();
            }
        });
        Thread t2 = new Thread(()-> {
            while(num.get()<100){
                add();
            }
        });
        Thread t3 = new Thread(()-> {
            while(num.get()<100){
                add();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.err.println("最终结果"+num.get());
    }
}
