package com.test.all.altest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

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
    public static List<List<Integer>> twoSum2(int[] nums, int begin, int target) {
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
    public static List<List<Integer>> twoSum1(int[] nums, int begin, int target) {
        int L=begin;
        int R = nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        while (L<R){
            if(nums[L]+nums[R]>target){
                R--;
            }else if(nums[L]+nums[R]<target){
                L++;
            }else {
                if(L==begin||nums[L]!=nums[L-1]){
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

    private List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i==0||nums[i]!=nums[i-1]){
                List<List<Integer>> temp = twoSum1(nums,0,-nums[i]);
                for (List<Integer> l :temp){
                    l.add(0,nums[i]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    //1 2 2 4 3
    public int findDuplicate(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        for(int i=0;i<nums.length;i++){
            if (nums[i]==i+1){
                i++;
                continue;
            }
            if(nums[i]==nums[nums[i]-1]){
                return nums[i];
            }
            int temp = nums[i];
            nums[i] =  nums[temp-1];
            nums[temp-1] =temp;
        }
        return 0;
    }



//    public String longestPalindrome(String s) {
//        char a ='啊';
//        int start ,end,length,maxlength;
//        int maxbegin ,maxend;
//
//
////        for(){
////
////        }
//        return s.substring(maxbegin,maxend+1);
//    }
    //(()) [) )) ]
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('('==c){
              stack.push(')');
            }else if('['==c){
                stack.push(']');
            }else if('{'==c){
                stack.push('}');
            }else {
                if(stack.isEmpty()||c!=stack.pop()){
                   return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
