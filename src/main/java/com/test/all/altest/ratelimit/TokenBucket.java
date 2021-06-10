package com.test.all.altest.ratelimit;

public class TokenBucket {
    private long lastTime;
    private long leftToken;
    private long rate;
    private long interval;
    private long capacity;

    public boolean tryAcquire(){
        long now =System.currentTimeMillis();
        long genTokenCount = (now-lastTime)/interval*rate;
        leftToken =Math.max(capacity,genTokenCount);
        if(leftToken>0){
            lastTime = now;
            leftToken--;
            return true;
        }
        return false;
    }
}
