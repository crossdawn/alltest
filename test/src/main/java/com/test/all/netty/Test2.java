package com.test.all.netty;

public class Test2 {
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            try {
//                System.err.println("初始"+Thread.interrupted());
//                System.err.println("初始"+Thread.interrupted());

//                TimeUnit.SECONDS.sleep(3);
                for(int i=0; i<500000; i++){
                    System.out.println("i="+(i+1));
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("中断后"+Thread.interrupted());

            }
        });
        t1.start();
        t1.interrupt();


    }
}
