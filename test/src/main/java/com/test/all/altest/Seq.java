package com.test.all.altest;

import java.util.ArrayList;
import java.util.List;

public class Seq {
    public static void main(String[] args) {
        int[] ia = {1, 2, 3, 3,4};
//        5,6,7,8,9,10};
//        int n = 5;
//        System.out.println("排列结果 : ");
//        p("",ia, 10);
        List<List<Integer>> result = permute(ia);
        System.err.println(result);
//	        System.out.println("组合结果 : ");
//	        combination(ia, n);
    }
    public static void permutation(String s, int[] ia, int n) {
        if(n == 1) {
            for(int i = 0; i < ia.length; i++) {
                System.out.println(s+ia[i]);
            }
        } else {
            for(int i = 0; i < ia.length; i++) {
                String ss = "";
                ss = s+ia[i]+"";
                //建立没有第i个元素的子数组
                int[] ii = new int[ia.length-1];
                int index = 0;
                for(int j = 0; j < ia.length; j++) {
                    if(j != i) {
                        ii[index++] = ia[j];
                    }
                }
                permutation(ss, ii, n-1);
            }
        }
    }
    public static void combination(int[] ia, int n) {
        combination("", ia, n);
    }
    public static void combination(String s, int[] ia, int n) {
        if(n == 1) {
            for(int i = 0; i < ia.length; i++) {
                System.out.println(s+ia[i]);
            }
        } else {
            for(int i = 0; i < ia.length-(n-1); i++) {
                String ss = "";
                ss = s+ia[i]+", ";
                //建立从i开始的子数组
                int[] ii = new int[ia.length-i-1];
                for(int j = 0; j < ia.length-i-1; j++) {
                    ii[j] = ia[i+j+1];
                }
                combination(ss, ii, n-1);
            }
        }
    }

    public static void p(String s,int[] chars,int n){
        if(n==1){
            for(int i=0;i<chars.length;i++){
                System.err.println(s+chars[i]);
            }
        }else {
            for(int i=0;i<chars.length;i++){
                String ss ="";
                ss=chars[i]+"";
                int index=0;
                int[] chars1 = new int[chars.length-1];
                for(int j=0;j<chars.length;j++){
                    if(chars[j]!=chars[i]){
                        chars1[index++] =  chars[j];
                    }
                }
                p(ss,chars1,n-1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub_res = new ArrayList<>();
        if(nums.length==0){return res;}
        p_dfs(res,nums,sub_res);
        return res;
    }
    public static void p_dfs(List<List<Integer>> res,int[] nums,List<Integer> sub_res){
        if(sub_res.size()==nums.length){
            res.add(new ArrayList<>(sub_res));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(!sub_res.contains(nums[i])){
                    sub_res.add(nums[i]);
                    p_dfs(res,nums,sub_res);
                    sub_res.remove(sub_res.size()-1);
                }

            }
        }

    }

    private void dfs(List<List<Integer>> res,int[] nums,List<Integer> sub_res){
        if(sub_res.size()==nums.length){
            res.add(sub_res);
        }else {
            for(int i=0;i<nums.length;i++){
                if(!sub_res.contains(nums[i])){
                    sub_res.add(nums[i]);
                    dfs(res,nums,sub_res);
                    sub_res.remove(sub_res.size()-1);
                }
            }
        }
    }

    public void print(int[] array ,int index){
        if (index==array.length) {
           return;
        }
        System.err.println(array[index]);
        print(array,++index);
    }


}
