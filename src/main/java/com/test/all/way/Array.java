package com.test.all.way;

import java.util.ArrayList;
import java.util.List;

public class Array {
    static List<List<Integer>> lists=new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> list=new ArrayList<>();
        if(nums.length==0||nums==null){
            return lists;
        }
        permute(nums,list,0);
        return lists;
    }

    private static void permute(int[] nums,  List<Integer> list, int index) {
        //边界值判断
        if(index==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        //i是从开始 i=index ;swap(,i)index相当于固定当前位置，在进行下一位的排列。
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);   //第一次交换定点之后的
            list.add(nums[index]); //把找到的加进去
            permute(nums,list,index+1); //进行递归
            list.remove(list.size()-1); //其中定位定完的需要定后面的数据
            swap(nums,index,i); //这是交换定点的，也就是重新返回上一级进行交换
        }

    }

    private static void swap(int[] nums, int index, int i) {
        int t =nums[index];
        nums[index] = nums[i];
        nums[i] = t;
    }

    public static void main(String[] args){
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> lists=new ArrayList<>();
        lists=permute(nums);
        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }



}
