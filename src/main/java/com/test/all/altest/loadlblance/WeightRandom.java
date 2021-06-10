package com.test.all.altest.loadlblance;

import com.test.all.controller.T;

import java.util.*;

public class WeightRandom {

    public TestServer select(List<TestServer> list){
        int totalWeight = 0;
        int[] weights = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            TestServer server = list.get(i);
            totalWeight+=server.weight;
            weights[i] =totalWeight;
        }
        int random = new Random().nextInt(totalWeight);
        for (int i=0;i<weights.length;i++){
            if(random<weights[i]){
                return list.get(i);
            }
        }
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args) {
        List<TestServer> list = new ArrayList<>();
        list.add(new TestServer("A",2));
        list.add(new TestServer("B",3));
        list.add(new TestServer("C",5));
        Map<String,Integer> count = new HashMap<>();
        WeightRandom weightRandom = new WeightRandom();
        for (int i=0;i<1000;i++){
            TestServer server = weightRandom.select(list);
            if(count.containsKey(server.name)){
                count.put(server.name,count.get(server.name)+1);
            }else {
                count.put(server.name,1);
            }
        }
        count.forEach((k,v)-> System.err.println(k+"次数"+v));
    }

}
