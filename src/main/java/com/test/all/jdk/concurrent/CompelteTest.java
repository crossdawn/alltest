package com.test.all.jdk.concurrent;

import java.util.Objects;
import java.util.concurrent.*;

public class CompelteTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {
        CompletableFuture<Void> addToCartFuture = CompletableFuture.runAsync(() -> {
            try {
                int i =1/0;
                TimeUnit.SECONDS.sleep(1);
                System.err.println("任务1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executor);
        CompletableFuture<Void> addToFavtFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("任务2");
        }, executor).whenComplete((a,b)->{if(Objects.nonNull(b)){
            System.err.println("任务2异常");
        }});

        CompletableFuture<Void> pageViewFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executor).whenComplete((a,b)->{if(Objects.nonNull(b)){
            System.err.println("任务3异常");
        }});
//        CompletableFuture.supplyAsync()
//        CompletableFuture.anyOf(addToCartFuture,addToFavtFuture,pageViewFuture).get();
//        CompletableFuture.allOf(addToCartFuture,addToFavtFuture,pageViewFuture).join();
        executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        try {
//           CompletableFuture.allOf(addToCartFuture,addToFavtFuture,pageViewFuture).complete( null);
            CompletableFuture<Object> future = CompletableFuture.anyOf();
            future.exceptionally((e) -> {
                return addToFavtFuture.cancel(true);
            });

//            CompletableFuture.allOf(addToCartFuture,addToFavtFuture,pageViewFuture).get();
//                    .whenComplete((a,b)->{if(Objects.nonNull(b)){
//                System.err.println("任务异常");
//            }});
        } catch (Exception e) {
            e.printStackTrace();

            executor.shutdown();

        }
    }
}
