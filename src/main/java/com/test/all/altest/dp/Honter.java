package com.test.all.altest.dp;

public class Honter {

    public static int h(int[] nums){
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] =nums[0];
        dp[1] =Math.max(nums[0],nums[1]);

        for(int i =2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static int h2(int[] nums){


        return Math.max(h(nums,1,nums.length),h(nums,0,nums.length-1));
    }

    public static int h(int[] nums,int start,int end){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp =new int[nums.length];
        for(int i =start;i<end;i++){
            if(i<=start+1){
                dp[start] =nums[start];
                dp[start+1] =Math.max(nums[start],nums[start+1]);
            }else {
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }
        return dp[end-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.err.println(h2(nums));
    }
}
