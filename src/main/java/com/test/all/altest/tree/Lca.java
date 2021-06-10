package com.test.all.altest.tree;

public class Lca {
//    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // base case
//        if (root == null) return null;
//        if (root == p || root == q) return root;
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        // 情况 1
//        if (left != null && right != null) {
//            return root;
//        }
//        // 情况 2
//        if (left == null && right == null) {
//            return null;
//        }
//        // 情况 3
//        return left == null ? right : left;
//    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        TreeNode left=lowestCommonAncestor( root.left,  p,  q);
        TreeNode right=lowestCommonAncestor( root.right,  p,  q);
        if(left==null&&right==null){
            return null;
        }
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
    public static void track(){

    }
}
