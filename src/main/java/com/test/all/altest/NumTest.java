package com.test.all.altest;

public class NumTest {
    //找出第一个k的位置
    private int getFirstK(int nums[], int k, int start, int end){
        if(start > end){
            return -1;
        }
        int middleIndex = (start + end) /2;
        int middleData = nums[middleIndex];
        if(middleData == k){
            //找出第一个位置k的终止条件：要么middleIndex=0;要么middleIndex > 0但是middleIndex-1处的位置不等于k
            if((middleIndex > 0 && nums[middleIndex-1]!=k) || middleIndex == 0){
                return middleIndex;
            }else{
                end = middleIndex -1;
            }
        }else if(middleData > k){
            end = middleIndex - 1;
        }else{
            start = middleIndex + 1;
        }
        return getFirstK(nums, k, start, end);
    }

    //找出最后一个k的位置
    private int getLastK(int nums[], int k, int start, int end){
        if(start > end){
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];
        if(middleData == k){
            //找出最后一个位置k的终止条件：要么middleIndex=长度-1;要么middleIndex < len-1但是middleIndex+1处的位置不等于k
            if((middleIndex < nums.length -1 && nums[middleIndex + 1] != k) || middleIndex == nums.length -1){
                return middleIndex;
            }else{
                start = middleIndex + 1;
            }
        }else if(middleData < k){
            start = middleIndex + 1;
        }else{
            end = middleIndex -1;
        }
        return getLastK(nums, k, start, end);
    }

    public int getNumberOfK(int nums[], int k){
        int number = 0;
        int len = nums.length;
        if(nums != null && len > 0){
            int firstK = getFirstK(nums, k, 0, len-1);
            int lastK = getLastK(nums, k, 0, len-1);
            if(firstK > -1 && lastK > -1){
                number = lastK - firstK + 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        NumTest m1 = new NumTest();
        int nums[] = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        int count = m1.getNumberOfK(nums, 3);
        System.out.println(count);
    }

}
