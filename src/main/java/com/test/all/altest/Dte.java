package com.test.all.altest;

/**
 * 打家劫舍
 */
public class Dte {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 3, 2};
        System.err.println(t(array));
    }

    public static int t(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        int[] dp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                dp[0] = array[0];
            } else if (i == 1) {
                dp[1] = Math.max(array[0], array[1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
            }
        }
        return dp[array.length - 1];
    }

}
