package com.test.all.jdk.thread;

import java.util.concurrent.TimeUnit;

public class DemoTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for(int i= 1;i<10000;i++){
                System.err.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        System.err.println("主线程开启");
    }
}
