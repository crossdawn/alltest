package com.test.all.way;

public class LeakBucket2 {
    private long lastAcquireTime;
    private long rate;
    private long nowCount;
    private long capacity;
    public boolean tryAcquire(){
        long now = System.currentTimeMillis();
        long outCount = (now-lastAcquireTime)*rate;
        nowCount = nowCount-outCount>0?nowCount-outCount:0;
        if(nowCount<capacity){
            nowCount++;
            lastAcquireTime =System.currentTimeMillis();
           return true;
        }else {
            return false;
        }
    }
}
