package com.test.all.jdk.thread;

import java.util.concurrent.ForkJoinPool;

public class SellTicket {
    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();
        Thread t1 = new Thread(tw, "一号窗口");
        Thread t2 = new Thread(tw, "二号窗口");
        Thread t3 = new Thread(tw, "三号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketWindow implements Runnable {
    private int tickets = 0;

    @Override
    public void run() {
        while (true) {
            if (tickets < 100) {
//                System.out.println("还剩余票:" + tickets + "张");
                tickets++;
                System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + tickets + "张");
            } else {
                System.out.println("余票不足,暂停出售!");
//                wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用
                try {
                    ForkJoinPool forkJoinPool = new ForkJoinPool();

                    Thread.sleep(1000 * 60 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
