package com.test.all.jdk.lang;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.apache.dubbo.common.utils.NamedThreadFactory;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Timer;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Htt {
    public static void main(String[] args) throws IOException {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(
                new NamedThreadFactory("dubbo-future-timeout", true),
                1,
                TimeUnit.SECONDS,
                500, true);
        hashedWheelTimer.start();
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                Thread.sleep(50_000);
                System.err.println("12312312");
            }
        }, 10, TimeUnit.SECONDS);
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
