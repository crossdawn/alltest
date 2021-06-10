package com.test.all.altest.off;

public class StrTest {

    public static int edit(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){

            dp[i][0]=i;
        }
        for(int j=0;j<m;j++){

            dp[0][j]=j;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] =Math.min(dp[i+1][j]+1,Math.min(dp[i][j+1]+1,dp[i][j]+1));
                }
            }
        }
        return dp[m][n];
    }

    public static int edit2(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=s1.charAt(0)==s2.charAt(0)?0:1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] =Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[m][n];
    }
    public void quickSort(int[] nums,int low,int high){
        if(low>high){
           return;
        }
        int index = partition(nums,low,high);
        quickSort(nums,low,index-1);
        quickSort(nums,index+1,high);
    }
    public int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        int L= low;
        int R= high;
        while (L<R){
            while (L<R&&nums[R]>=pivot){
                R--;
            }
            nums[L] =nums[R];
            while (L<R&&nums[L]<=pivot){
                L++;
            }
            nums[R] =nums[L];
        }
        nums[L] = pivot;
        return L;
    }


    public static void main(String[] args) {
        System.err.println(edit2("horse","ros"));
        System.err.println(edit("horse","ros"));
    }
}
