package com.test.all.altest;

public class DpTest {
    public static void main(String[] args) {

    }

    private static int calculateCount(int ladder, int maxJump) {
        int jump = 0;
        if (ladder == 0) {
            return 1;
        }
        if (ladder >= maxJump) {
            // 剩下的楼梯大于最大可跳跃数
            for (int i = 1; i <= maxJump; i++) {
                jump += calculateCount(ladder - i, maxJump);
            }
        } else {
            // 剩下的楼梯不足最大可跳跃数
            jump = calculateCount(ladder, ladder);
        }
        return jump;
    }


    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        int[] coins = {1,5,10,25};
        for(int i = 0;i <= n;i++){
            dp[i] = 1;
        }
        for(int j = 1;j < 4; j++){
            for(int i = 0;i <= n;i++){
                if(i >= coins[j]){
                    dp[i] = (dp[i] + dp[i - coins[j]])%1000000007;
                }

            }
        }
        return dp[n];
    }

}
