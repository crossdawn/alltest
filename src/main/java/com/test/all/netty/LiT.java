package com.test.all.netty;

import java.util.ArrayList;
import java.util.List;

public class LiT {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1,1);

        list.add(2,2);
        list.add(3,3);
        list.remove(2);
        System.err.println(list.get(2));

    }
}
