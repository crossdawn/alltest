package com.test.all.altest.loadlblance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightRoundBobin {

    public TestServer select(List<TestServer> list){
        int totalWeight= 0;
        TestServer maxNode =null;
        int maxWeight=0;
        for(int i=0;i<list.size();i++){
            TestServer server = list.get(i);
            totalWeight+=server.weight;
            server.currentWeight = server.weight+server.currentWeight;
            if(maxNode==null||maxWeight<server.currentWeight){
                maxNode =server;
                maxWeight = server.currentWeight;
            }
        }
        maxNode.currentWeight =maxNode.currentWeight-totalWeight;

        return maxNode;
    }

    public static void main(String[] args) {
        List<TestServer> list = new ArrayList<>();
        list.add(new TestServer("A",1));
        list.add(new TestServer("B",3));
        list.add(new TestServer("C",6));
        Map<String,Integer> count = new HashMap<>();
        WeightRoundBobin weightRoundBobin = new WeightRoundBobin();
        for (int i=0;i<100000;i++){
            TestServer server = weightRoundBobin.select(list);
            if(count.containsKey(server.name)){
                count.put(server.name,count.get(server.name)+1);
            }else {
                count.put(server.name,1);
            }
        }
        count.forEach((k,v)-> System.err.println(k+"次数"+v));
    }
}
