package com.test.all.way;

public class LeakBucket {
    // 起始时间
    private static long startTime = System.currentTimeMillis();
    private long speed=20L;
    private long capacity=100L;
    private long nowCount;

    public LeakBucket(long speed, long capacity, long nowCount) {
        this.speed = speed;
        this.capacity = capacity;
        this.nowCount = nowCount;
    }

    public boolean tryAcquire(){
        long nowTime = System.currentTimeMillis();
        long outCount =speed*(nowTime-startTime);
        nowCount  = nowCount-outCount<0?0L:nowCount-outCount;
        if(nowCount<capacity){
            startTime = nowTime;
            nowCount++;
            return true;
        }else {
            return false;
        }
    }

}
