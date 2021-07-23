package com.test.all.altest.tree;

import java.util.Arrays;
import java.util.Stack;

public class MaxDeep {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null||subRoot==null){
            return false;
        }
        if(root.value==subRoot.value){
            return true;
        }
        return isSubtree(root.left,root.left)&&isSubtree(root.right,root.right);
    }

    public int coin(int[] coins,int amount){
        int[] m = new int[amount+1];
        m[0] =0;
        for(int i=1;i<=amount;i++){
            int min =Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&m[i-coins[j]]<min){
                    min = m[i-coins[j]]+1;
                }
            }
            m[i] = min;
        }
        return m[amount]==Integer.MAX_VALUE?-1:m[amount];
    }
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }



    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxLength){
                res += count[i];
            }
        }
        return res;
    }



    public int findNumberOfLIS2(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) if (nums[i] < nums[j]) {
                if (lengths[i] >= lengths[j]) {
                    lengths[j] = lengths[i] + 1;
                    counts[j] = counts[i];
                } else if (lengths[i] + 1 == lengths[j]) {
                    counts[j] += counts[i];
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public int minDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int minLeft = minDepth(root.left);
        int minRight =minDepth(root.right);
        if(root.left==null||root.right==null){
            return minLeft+minRight+1;
        }
        return Math.min(minLeft,minRight)+1;
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int capacity =10;


    public void appendTail(int value) {
        stack1.push(value);

    }



    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }
}
