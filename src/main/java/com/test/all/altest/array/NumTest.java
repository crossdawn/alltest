package com.test.all.altest.array;

import java.util.*;

public class NumTest {
    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5};
        largestNumber(nums);
    }

    public static void largestNumber(int[] nums) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        process(nums,0,new LinkedList<>(),result);
        result.forEach(x-> System.err.println(Arrays.toString(x.toArray())));
    }
    public static void process(int[] nums, int index, LinkedList<Integer> path, List<LinkedList<Integer>> result) {
        if(index ==nums.length){
            result.add(new LinkedList<>(path));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            path.add(nums[i]);
            process(nums,index+1,path,result);
            path.removeLast();
        }
    }

}
