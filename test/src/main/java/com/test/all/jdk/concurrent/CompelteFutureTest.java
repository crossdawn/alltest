package com.test.all.jdk.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompelteFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, Executors.newFixedThreadPool(4));
        future.whenComplete((retValue, exception) -> {
            if (exception == null) {
                System.err.println("2");
                System.out.println(retValue);
            } else {
                exception.printStackTrace();
            }
        });
        System.err.println("1234");
//        Executors.newFixedThreadPool(4).submit(new Callable<Object>() {
//        })

    }
}
