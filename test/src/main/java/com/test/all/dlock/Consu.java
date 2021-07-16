package com.test.all.dlock;


public class Consu {
    private int i =0;
    private int capacity =10;
    public synchronized void product() throws InterruptedException {
        while (i>=capacity){
            this.wait();
        }
        i++;
        System.err.println(Thread.currentThread().getName()+"生产"+i);
        this.notify();
    }
    public synchronized void consumer()throws InterruptedException{
        while (i<=0){
            this.wait();
        }
        i--;
        System.err.println(Thread.currentThread().getName()+"消费"+i);
        this.notify();
    }

    public static void main(String[] args) {
        Consu consu = new Consu();
        new Thread(()->{
            try {
                while (true){
                    consu.product();
                    Thread.sleep(50);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                while (true){
                    consu.consumer();
                    Thread.sleep(500);
                }            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                while (true){
                    consu.product();
                    Thread.sleep(100);

                }            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        new Thread(()->{
//            try {
//                while (true){
//                    consu.consumer();
//                    Thread.sleep(50);
//
//                }            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
