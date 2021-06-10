package com.test.all.jdk.concurrent;

import org.apache.dubbo.common.threadlocal.NamedInternalThreadFactory;
import org.apache.dubbo.common.threadpool.support.AbortPolicyWithReport;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Thread t1 = new Thread(()->{
//            try {
//                Thread.sleep(100_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.execute(t1);
//        t1.interrupt();
//        executorService.shutdownNow();
        AtomicReference<Integer> a = new AtomicReference<>(1);
//        Future<AtomicReference<Integer>> future =  executorService.submit(()->{
//            a.set(2);
//            try {
//                Thread.sleep(10_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int i = 1/0;
//        }, a);
//        ThreadPoolExecutor
//        executorService.submit();
//        future.cancel(false);
//        System.err.println(future.isCancelled());
//
//        System.err.println(future.isDone());
//        future.get();
//        System.err.println(a.get());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1),
                new NamedInternalThreadFactory("name", true), new MyDiscardOldestPolicy());
        threadPoolExecutor.execute(new MyTask("AAA"));
        threadPoolExecutor.execute(new MyTask("BBB"));
        threadPoolExecutor.execute(new MyTask("CCC"));

    }
}
