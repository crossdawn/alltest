package com.test.all.tree;

import java.util.LinkedList;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
//        print(root);
//        System.err.println(height(root));
        firtRoot(root);
    }

    public static void print(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            System.err.println(treeNode.data);
            if (treeNode.left != null) {
                queue.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.addLast(treeNode.right);
            }
        }
    }

    public static int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftH = height(treeNode.left);
        int rightH = height(treeNode.left);
        return Math.max(leftH, rightH) + 1;
    }

    public static void firtRoot(TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }
        System.err.println(treeNode.data);;
        firtRoot(treeNode.left);
        firtRoot(treeNode.right);
    }

}
