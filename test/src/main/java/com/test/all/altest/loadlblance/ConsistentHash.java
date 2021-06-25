package com.test.all.altest.loadlblance;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

public class ConsistentHash {
    public TestServer select(List<TestServer> list){
        TreeMap<Integer,TestServer> treeMap = new TreeMap<>();
        list.forEach(x->{
            treeMap.put(1,x);
        });
        String param = "";
        Integer hash = 111;
        Integer key = treeMap.ceilingKey(hash);
        if(Objects.isNull(key)){
            return list.get(new Random(list.size()).nextInt());
        }
        return treeMap.get(key);
    }
}
