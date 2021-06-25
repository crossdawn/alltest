package com.test.all.jdk.lang;


import io.netty.util.Timeout;
import io.netty.util.TimerTask;

public class OrderTimerTask implements TimerTask {
    private String orderSn;

    public OrderTimerTask(String orderSn) {
        this.orderSn = orderSn;
    }

    @Override
    public void run(Timeout timeout) throws Exception {
        System.err.println("检查订单超时:"+orderSn);
    }
}
