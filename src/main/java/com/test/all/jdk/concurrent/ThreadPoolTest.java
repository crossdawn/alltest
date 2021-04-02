package com.test.all.jdk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(t1);
        t1.interrupt();
        executorService.shutdownNow();
    }
}
