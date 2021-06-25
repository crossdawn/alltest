package com.test.all.altest;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 */
public class FbTest {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.err.println(f(6));
        System.err.println(f2(6));
        System.err.println(f1(6));
    }

    //112358
    public static int f(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        return f(n - 2) + f(n - 1);
    }

    public static Integer f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        return cache.computeIfAbsent(n, (k) -> f1(n - 1) + f1(n - 2));
    }

    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        int pre = 1;
        int cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
