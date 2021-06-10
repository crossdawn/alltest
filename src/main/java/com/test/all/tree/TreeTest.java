package com.test.all.tree;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//        firtRoot(root);
        System.err.println(height2(root));
        System.err.println(print2(root));
        List<Integer> list = new ArrayList<>();
        firstRoot(list,root);
        System.err.println(list);

        List<Integer> list2 = new ArrayList<>();
        midRoot(list2,root);
        System.err.println(list2);

        List<Integer> list3 = new ArrayList<>();
        lastRoot(list3,root);
        System.err.println(list3);

    }
    public static int height2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
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
    public static List<Integer> print2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            list.add(treeNode.data);
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
        }
        return list;
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

    public static void firstRoot(List<Integer> list , TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }
        list.add(treeNode.data);
        firstRoot(list,treeNode.left);
        firstRoot(list,treeNode.right);
    }

    public static void midRoot(List<Integer> list , TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }
        midRoot(list,treeNode.left);
        list.add(treeNode.data);
        midRoot(list,treeNode.right);
    }

    public static void lastRoot(List<Integer> list , TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }
        lastRoot(list,treeNode.left);
        lastRoot(list,treeNode.right);
        list.add(treeNode.data);
    }

}
