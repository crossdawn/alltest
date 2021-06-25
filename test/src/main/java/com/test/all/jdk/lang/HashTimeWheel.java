package com.test.all.jdk.lang;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import org.apache.dubbo.common.utils.NamedThreadFactory;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class HashTimeWheel {
    private     static    Map<String, List<Timeout>> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(
                new NamedThreadFactory("dubbo-future-timeout", true),
                1,
                TimeUnit.SECONDS,
                500, true);
        hashedWheelTimer.start();
        OrderTimerTask orderTimerTask = new OrderTimerTask("234");
        Timeout timeout = hashedWheelTimer.newTimeout(orderTimerTask, 10, TimeUnit.SECONDS);
        Timeout timeout2 = hashedWheelTimer.newTimeout(orderTimerTask, 20, TimeUnit.SECONDS);
        Timeout timeout3 = hashedWheelTimer.newTimeout(orderTimerTask, 30, TimeUnit.SECONDS);
        List<Timeout> list = new ArrayList<>();
        list.add(timeout);
        list.add(timeout2);
        list.add(timeout3);

        cache.put("123", list);
       cache.get("123").forEach(x->x.cancel());
        System.err.println(timeout.isExpired());
        System.err.println(timeout.isCancelled());

        System.err.println(timeout2.isCancelled());
        System.err.println(timeout3.isCancelled());













        System.in.read();
        DelayQueue delayQueue;
//        delayQueue.poll()
        FileChannel fileChannel;
//        System.err.println(200&99);
//        System.err.println(200%99);

//        System.err.println(16&15);
//        System.err.println(15&15);
//        System.err.println(15&15);


    }
}
