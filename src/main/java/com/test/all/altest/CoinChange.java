package com.test.all.altest;

import java.util.concurrent.CompletableFuture;

public class CoinChange {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture =CompletableFuture.completedFuture(sayHello());
        System.err.println("异步");
        int[][] a = new int[3][4];
        for (int i=0;i<3;i++){
            for (int j=0;j<4;j++){
                a[i][j]=0;
            }
        }
        System.err.println(a.length);
    }
    public int coinChange(int[] coins, int amount) {
        int[] m =new int[amount+1];
        m[0]=0;
        for(int i=0;i<=amount;i++){
            int min =Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){{
                if(i-coins[j]>=0&&m[i-coins[j]]<min){
                    min =m[i-coins[j]]+1;
                }
            }
            m[i] = min;
            }
        }
        return m[amount]==Integer.MAX_VALUE?-1:m[amount];
    }

//    int change(int amount, vector<int>& coins) {
//        int dp[amount+1];
//        memset(dp, 0, sizeof(dp)); //初始化数组为0
//        dp[0] = 1;
//        for (int j = 1; j <= amount; j++){ //枚举金额
//            for (int coin : coins){ //枚举硬币
//                if (j < coin) continue; // coin不能大于amount
//                dp[j] += dp[j-coin];
//            }
//        }
//        return dp[amount];
//    }

    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        // dp[j]:在区间[0, i]能凑成金额j的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
                    min = memo[i-coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    public static String sayHello(){
        try{
            Thread.sleep(1_0000);
            System.err.println("超时");
            return "hello";
        }catch (Exception e){

        }
        finally {
            return "hi";

        }
    }

    public static int uniquePaths(int[][] arr) {
        int m =arr.length;
        int n = arr[0].length;
        int[][] dp =new int[m][n];
        for (int i=1;i<m;i++){

        }
        return 1;
    }
}
