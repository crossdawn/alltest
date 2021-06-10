package com.test.all.altest.off;

import java.util.Arrays;

public class SubCollection {
    public boolean can(int[] nums,int k){
        int sum =0;
        for(int i :nums){
            sum+=i;
        }
        Arrays.sort(nums);
        for(int i=0,j=nums.length-1;i<j;i++,j--){
            int temp = nums[j];
            nums[j] =nums[i];
            nums[i] =temp;
        }
        int target = sum/k;
        int[] buckets = new int[k];
        return process(nums,0,buckets,target);
    }
    public boolean process(int[] nums,int index,int[] buckets,int target){
        if(index==nums.length){
            for(int i:buckets){
                if(i!=target){
                    return false;
                }
            }
            return true;
        }
        for(int i=0;i<buckets.length;i++){
            if(buckets[i]+nums[index]>target){
                continue;
             }
            buckets[i]+=nums[index];
            if(process(nums,index+1,buckets,target)){
                return true;
            }
            buckets[i]-=nums[index];
        }
        return true;
    }

}
