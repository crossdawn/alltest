package com.test.all.altest.ratelimit;

import java.util.LinkedList;

public class Window {
    private int limit=10;
    private int interval=1;

    LinkedList<Long> timeList = new LinkedList<>();
    long lastTime =0;
    public boolean canPass(){
        long now =System.currentTimeMillis();
        if(timeList.size()<limit){
            timeList.add(now);
            return true;
        }
        long fisrtTime =timeList.peekFirst();
        if(now-fisrtTime<1){
            return false;
        }
        timeList.removeFirst();
        timeList.addLast(now);
        return true;
    }
}
