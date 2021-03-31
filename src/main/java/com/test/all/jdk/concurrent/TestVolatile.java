package com.test.all.jdk.concurrent;

public class TestVolatile {
    int testNumber = 0;
    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();
        Thread t1 = new Thread(()->{
            for(int i =1;i<=100;i++){
                testVolatile.testNumber=i;
            }
            System.out.println("已经加到了"+testVolatile.testNumber);
        });
        Thread t2 = new Thread(()->{
            while (true){
//                System.out.println("检测");
                if (testVolatile.testNumber==100){
                    System.out.println("检测到已经加到了100");
                    break;
                }
            }
        });
        t2.start();
        Thread.sleep(3000L);
        t1.start();
    }
}
