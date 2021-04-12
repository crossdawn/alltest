package com.test.all.altest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NumSum3 {
    public static void main(String[] args) throws Exception{
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        int[][] array  ={{1,2,3},{4,5,6},{1,2,3}};
        array[0]= new int[]{0, 0, 0};
        System.out.println(unsafe.arrayBaseOffset(array.getClass()));

    }
    int[] a ={2,3,5,3,1,0};
    private int way(int[] array){
        int[][] result = new int[array.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<array.length;i++){
            if(stack.empty()){
                result[i][0]=0;
                result[i][1]=array[i];
            }
            int temp = stack.peek();
            if(array[temp]<array[i]){
                stack.push(array[i]);
            }
            while (!stack.empty()&&temp>array[i]){

            }
            result[i][0]=0;

            result[i][1]=array[i];

        }
        return 0;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 第一个数选了i位置的数
        for(int i=0;i<nums.length-2;i++){
            if(i==0||nums[i]!=nums[i-1]){
                List<List<Integer>> re =  twoSum1(nums,i,-nums[i]);
                for(List<Integer> l:re){
                    l.add(0,nums[i]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    public static List<List<Integer>> twoSum1(int[] nums, int begin, int target) {
        int L =begin;
        int R =nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        while (L<R){
            if(nums[L]+nums[R]>target){
                R--;
            }else if(nums[L]+nums[R]<target){
                L++;
            }else {
                if(nums[L]==begin||nums[L-1]!=nums[L]){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(L);
                    cur.add(R);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }
}
