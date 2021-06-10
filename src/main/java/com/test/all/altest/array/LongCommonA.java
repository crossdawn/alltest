package com.test.all.altest.array;

import com.test.all.altest.tree.TreeNode;

import java.util.Arrays;

public class LongCommonA {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1==null|| nums2==null){
            return 0;
        }
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0]==nums2[0]?1:0;
//        for(int i=1;i<nums1.length-1;i++){
//            dp[i][0] = nums1[i]==nums2[0]?1:dp[i-1][0];
//        }
//        for(int j=1;j<nums2.length-1;j++){
//            dp[0][j] = nums1[0]==nums2[j]?1:dp[0][j-1];
//        }
        int ans =0;
        for(int i=1;i<nums1.length;i++){
            for(int j=1;j<nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]  = dp[i-1][j-1]+1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
    //12345
    public int search(int[] nums, int target) {
        int left =0;
        int right =nums.length-1;
        while (left<=right){
//            int middle =(left+right)/2;
            int middle =left+(right-left)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                right = middle-1;
            }else {
               left =middle+1;
            }
        }
        return -1;
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker =0;
        for(int i = 0; i < 4; i++) {
            if(nums[i]==0){
                joker++;
            }else{
                if(nums[i] == nums[i + 1])
                {
                    return false;
                }
            }
        }
        return nums[nums.length-1]-nums[joker]<5;
    }

    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int a =0;
        int b =1;
        int ans = 0;
        for(int i=2;i<=n;i++){
            ans = (a+b)%1000000007;
            a =b;
            b =ans;
        }
        return ans;
    }

}
