package com.test.all.netty;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c = () -> {
            try {
                System.err.println("模拟任务耗时");
//                int i =1/0;
                Thread.sleep(100_000);
                return 1;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
            return 1;
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue(1));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        System.err.println(threadPoolExecutor.getCorePoolSize());
        System.err.println(threadPoolExecutor.getActiveCount());
        Future<Integer> f = threadPoolExecutor.submit(c);
//        System.err.println("结果"+f.get());a

        System.err.println(threadPoolExecutor.getTaskCount());
        System.err.println(threadPoolExecutor.getCompletedTaskCount());
        System.err.println("执行结果"+f.isDone());

        System.err.println(threadPoolExecutor.getActiveCount());

        System.err.println(threadPoolExecutor.getCorePoolSize());
        f.cancel(true);
        System.err.println(threadPoolExecutor.getCorePoolSize());

        threadPoolExecutor.shutdownNow();
    }
}
