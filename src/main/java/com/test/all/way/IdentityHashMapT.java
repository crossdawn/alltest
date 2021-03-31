package com.test.all.way;

import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.TreeMap;

public class IdentityHashMapT {
    public static void main(String[] args) {
        IdentityHashMap<String,String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("1","");
        String c = "😂";
        System.err.println(c.getBytes().length);


        TreeMap<String,String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });
        treeMap.put("1","1");
        treeMap.put("2","2");
        treeMap.put("3","3");
        System.err.println(treeMap.ceilingEntry("0").getValue());

    }
}
