package com.test.all.altest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestFb {
    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("f(" + 14 + ") =" + fibonacci(14));
    }

    static int fibonacci(int i) {
        if (i == 0)
            return i;
        if (i == 1)
            return 1;
        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("Slow calculation of " + key);
            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }
}
