package com.test.all.altest.ratelimit;

public class LeakBucket {
    private long lastTime;
    private long nowCount;
    private long rate;
    private long interval;
    private long capacity;

    public boolean tryAcquire(){
        long now =System.currentTimeMillis();
        long outCount = (now-lastTime)/interval*rate;
        nowCount =outCount-nowCount<0?0:outCount-nowCount;
        if(nowCount<capacity){
            lastTime = now;
            nowCount++;
            return true;
        }
        return false;
    }
}
