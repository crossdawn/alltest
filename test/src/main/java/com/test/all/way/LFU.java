package com.test.all.way;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class LFU {
    private Map<String,Object> data;
    private Map<String,Integer> freqRecord;
    private Map<Integer, LinkedHashSet<String>> keyRecord;
    private int capacity;
    private int minFreq;

    public LFU(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        data = new HashMap<>();
        freqRecord = new HashMap<>();
        keyRecord = new HashMap<>();
    }

    public Object get(String key){
        Object o = data.get(key);
        if(o==null){
            return null;
        }
        incease(key);
        return o;
    }

    private void incease(String key){
        //频率+1
        int freqOld = freqRecord.get(key);
        int newFreq = freqOld+1;
        freqRecord.put(key,newFreq);
        //移动到 频率+1 的集合中
        LinkedHashSet<String> keySet = keyRecord.get(freqOld);
        keySet.remove(key);
        if (keySet.isEmpty()) {
            keyRecord.remove(freqOld);
            // 如果该 frequency 恰好是 minFrequency，更新 minFrequency 的值
            if (freqOld == this.minFreq) {
                this.minFreq++;
            }
        }
        LinkedHashSet<String> newKeySet = keyRecord.get(newFreq);
        if(Objects.isNull(newKeySet)){
            newKeySet = new LinkedHashSet<>();
        }
        newKeySet.add(key);
        keyRecord.put(newFreq,newKeySet);
    }

    public void put(String key,Object o){
        if(data.containsKey(key)){
            freqRecord.put(key,freqRecord.get(key)+1);
            return;
        }
        if(data.size()>=capacity){
            //移除频率最小
            removeMiniFreqKey();
        }
        data.put(key,o);
        freqRecord.put(key,1);
        keyRecord.putIfAbsent(1,new LinkedHashSet<>());
        keyRecord.get(1).add(key);
        this.minFreq=1;
    }

    private void removeMiniFreqKey(){
        LinkedHashSet<String> keySet = keyRecord.get(minFreq);
        String oldKey = keySet.iterator().next();
        keySet.remove(oldKey);

        if(keySet.isEmpty()){
            keyRecord.remove(minFreq) ;
        }
        data.remove(oldKey);
        freqRecord.remove(oldKey);
    }

    public static void main(String[] args) {
        LFU lfu = new LFU(3);
        lfu.put("1",1);
        lfu.get("1");

        lfu.put("2",2);
        lfu.get("2");

        lfu.put("3",3);
        lfu.get("3");

        lfu.put("4",4);
        lfu.get("4");
        lfu.get("4");
        lfu.put("5",5);
        lfu.data.forEach((k,v)->{
            System.err.println(k+":"+v);
        });
    }
}
