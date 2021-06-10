package com.test.all.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class T {
    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent(
                "AaAa",
                key -> {
                    return map.computeIfAbsent(
                            "BBBB",
                            key2 -> 42);
                }
        );
    }

}
