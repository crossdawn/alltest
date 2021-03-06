package com.test.all.altest;

import java.util.ArrayList;
import java.util.List;

public class Otest {
    private static List<Object> list= new ArrayList<>();
    public static void main(String[] args) {
        try{

            while (true){
                list.add(new Object());
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.err.println(new Object());
        }
        System.out.println("134");
//        while (true){
//            list.add(new Object());
//        }
    }
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[][] dp = new int[len][amount + 1];
        dp[0][0] = 1;

        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i] >= 0) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }
}
