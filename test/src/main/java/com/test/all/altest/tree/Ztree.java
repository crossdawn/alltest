package com.test.all.altest.tree;

import java.util.*;

public class Ztree {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftOrder =true;
        while (!queue.isEmpty()){
            LinkedList<Integer> curLevel = new LinkedList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                if(isLeftOrder){
                    curLevel.addLast(treeNode.value);
                }else {
                    curLevel.addFirst(treeNode.value);
                }
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
            ans.add(curLevel);
            isLeftOrder = !isLeftOrder;
        }
        return ans;
    }


}
