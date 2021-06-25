package com.test.all.jdk.thread;


import java.util.concurrent.CountDownLatch;

public class NumberAdd2 {

    static class NewNumber {
        public int num;
        public NewNumber(int num) {
            this.num = num;
        }
    }

    private  static void add(NewNumber newNumber){
        while (newNumber.num<100){
            ++newNumber.num;
//            System.err.println(Thread.currentThread().getName()+":"+(++newNumber.num));
        }
    }
    private static void exec()throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        NewNumber newNumber = new NewNumber(0);
        Thread t1 = new Thread(()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                add(newNumber);


//            while (newNumber.num<100){
//                add(newNumber);
//            }
        },"线程1");
        Thread t2 = new Thread(()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                add(newNumber);

//            while (newNumber.num<100){
//                add(newNumber);
//            }
        },"线程2");
        Thread t3 = new Thread(()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                add(newNumber);

//            while (newNumber.num<100){
//                add(newNumber);
//            }
        },"线程3");
        t1.start();
        t2.start();
        t3.start();
        countDownLatch.countDown();
        t1.join();
        t2.join();
        t3.join();
        if(newNumber.num!=100){
            System.err.println("最终结果"+newNumber.num);
        }
    }
    public static void main(String[] args) throws Exception{
        int i =0;
        while (i<1_0000_0000){
            exec();
            i++;
        }
    }
}
