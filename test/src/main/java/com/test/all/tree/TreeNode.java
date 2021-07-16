package com.test.all.tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public static TreeNode bst(int[] nums,int L,int R){
        if(L>R){
            return null;
        }
        if(L==R){
            return new TreeNode(nums[L]);
        }
        int M = (L+R)/2;
        TreeNode root = new TreeNode(nums[M]);
        root.left = bst(nums, L, M - 1);
        root.right = bst(nums, M + 1, R);
        return root;

    }
}
