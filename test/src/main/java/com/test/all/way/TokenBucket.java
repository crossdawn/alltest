package com.test.all.way;

public class TokenBucket {
    private long rate;
    private long generatedToken;
    private long capacity;
    private long leftToken;

    // 起始时间
    private static long lastAcquireTime = System.currentTimeMillis();
    public boolean tryAcquire(){
        long nowTime = System.currentTimeMillis();
        long generatedToken = (nowTime-lastAcquireTime)*rate;
        leftToken = Math.min(capacity,leftToken+generatedToken);
        if(leftToken>=1){
            lastAcquireTime =nowTime;
            leftToken--;
            return true;
        }else {
            return false;
        }
    }
}
