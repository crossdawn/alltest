package com.test.all.altest.tree;

import java.util.*;

public class BstTreeTest {
    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {

       TreeNode root =  generateRandomBST(3,30);
       StringBuilder sb  =new StringBuilder();
        rootFirst(root,sb);
        System.err.println("前序"+sb.toString());

       List<String> result =print(root);
        String[] strs = result.toArray(new String[]{});
        System.err.println("层次1"+Arrays.toString(strs));

        TreeNode root2 = deser(strs);
        List<String> result2 =print(root2);
        String[] strs2 = result2.toArray(new String[]{});
        System.err.println("层次2"+Arrays.toString(strs2));


//       StringBuilder sb  =new StringBuilder();
//        rootFirst(root,sb);
//        System.err.println(sb.toString());
    }

    public static List<String> print(TreeNode root){
        if(root ==null){
            return new LinkedList<>() ;
        }
        LinkedList<String> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp =queue.poll();
            if(temp==null){
                result.offer("NULL");
                continue;
            }
            result.offer(temp.value+"");

            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return result;
    }

    public static TreeNode deser(String[] strs){
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i =1;i<strs.length;i++){
            TreeNode parent = queue.poll();

            String left = strs[i++];
            if("NULL".equals(left)){
                parent.left =null;
            }else {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            }

            String right = strs[i++];
            if("NULL".equals(right)){
                parent.right =null;
            }else {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            }
        }
        return root;
    }


    public static void rootFirst(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("NULL");
            return;
        }
        sb.append(node.value);
        rootFirst(node.left,sb);
        rootFirst(node.right,sb);
    }

    public static TreeNode rootFirstDe(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String node = list.removeFirst();
        if("NULL".equals(node)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left=rootFirstDe(list);
        root.right=rootFirstDe(list);
        return root;
    }

    public static void rootLast(TreeNode node,StringBuilder sb){
        if(node==null){
           sb.append("NULL");
           return;
        }
        rootLast(node.left,sb);
        rootLast(node.right,sb);
        sb.append(node.value);
    }

    public static TreeNode rootLastDe(LinkedList<String> list){
        if(list==null){
            return null;
        }
        String node = list.removeLast();
        if("NULL".equals(node)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.right = rootLastDe(list);
        root.left = rootLastDe(list);
        return root;
    }

    public static boolean isBst(TreeNode node){
        if(node==null){
            return true;
        }
        return process(node).isBST;
    }

    public static Info process(TreeNode node){
        if(node==null){
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int maxVal =node.value;
        if(leftInfo!=null){
            maxVal =Math.max(maxVal,leftInfo.maxVal);
        }
        if(rightInfo!=null){
            maxVal =Math.max(maxVal,rightInfo.maxVal);
        }
         int minVal =node.value;
        if(leftInfo!=null){
            minVal =Math.min(minVal,leftInfo.minVal);
        }
        if(rightInfo!=null){
            minVal =Math.min(minVal,rightInfo.minVal);
        }
         boolean isBST =true;

        if(leftInfo!=null&&!leftInfo.isBST){
            isBST =false;
        }
        if(rightInfo!=null&&!rightInfo.isBST){
            isBST =false;
        }
        if(leftInfo!=null&&leftInfo.maxVal>=node.value){
            isBST =false;
        }
        if(rightInfo!=null&&rightInfo.minVal<=node.value){
            isBST =false;
        }
        return new Info(maxVal,minVal,isBST);
    }

    public static class Info{
        public int maxVal;
        public int minVal;
        public boolean isBST;

        public Info(int maxVal, int minVal, boolean isBST) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.isBST = isBST;
        }

    }


    public int getMax(TreeNode node){
        if(node ==null){
            return 0;
        }
        Info2 info = process2(node);
        return Math.max(info.yes,info.no);
    }
    public Info2 process2(TreeNode node){
        if(node ==null){
            return new Info2(0,0);
        }
        Info2 left = process2(node.left);
        Info2 right = process2(node.right);
        int no =left.yes+right.yes+node.value;
        int yes = Math.max(left.yes,left.no)+Math.max(right.yes,right.no);
        return new Info2(yes,no);
    }

    static class Info2{
        int yes;
        int no;

        public Info2(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }
}
