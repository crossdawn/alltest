package com.test.all.way;

public class TokenBucket2 {
    private long lastAcquireTime =System.currentTimeMillis();
    private long speed;
    private long leftCount =0;
    private long capacity;

    public boolean acquire(){
        long now =System.currentTimeMillis();
        long genrateCount = (now-lastAcquireTime)*speed;
        leftCount  = Math.min(capacity,leftCount+genrateCount);
        if(leftCount>=1){
            leftCount--;
            lastAcquireTime=now;
            return true;
        }else {
            return false;
        }
    }
}
