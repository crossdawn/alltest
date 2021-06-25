package com.test.all.altest.loadlblance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleRoundBobin {

    int a =0;
    public TestServer select(List<TestServer> list){
        return list.get(a++%list.size());
    }

    public static void main(String[] args) {
        List<TestServer> list = new ArrayList<>();
        list.add(new TestServer("A",1));
        list.add(new TestServer("B",3));
        list.add(new TestServer("C",6));
        Map<String,Integer> count = new HashMap<>();
        SingleRoundBobin singleRoundBobin = new SingleRoundBobin();
        for (int i=0;i<100000;i++){
            TestServer server = singleRoundBobin.select(list);
            if(count.containsKey(server.name)){
                count.put(server.name,count.get(server.name)+1);
            }else {
                count.put(server.name,1);
            }
        }
        count.forEach((k,v)-> System.err.println(k+"次数"+v));
    }
}
