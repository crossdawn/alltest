package com.test.all.altest;

public class CoinTest {
    public int coin(int[] coins,int amount){
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i =1;i<=amount;i++){
            for(int j =0;i<coins.length-1;j++){
//                if(coins[j]<i&&){
//
//                }
//                dp[i] = ;
            }
        }
        return dp[amount];
    }
}
