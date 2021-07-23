package com.test.all.altest;

import java.util.Arrays;
import java.util.LinkedList;

public class Windows {
    public static void main(String[] args){
    int[] arr = {4,2,5,6,3,1,2,4};
    printArray(maxSlidingWindow(arr,3));
        System.err.println(partition(arr,0,arr.length-1));
        System.err.println(Arrays.toString(arr));
}
        //[1,3,-1,-3,5,3,6,7], k = 3
    public static int[] getMaxWindow2(int[] arr, int w) {
        if(arr==null||w<1||arr.length<w){
            return null;
        }
        int[] result = new int[arr.length-w+1];
        int index =0;
        LinkedList<Integer> qMax = new LinkedList<>();
        for(int i =0;i<arr.length;i++){
            while (qMax.peekLast()<arr[i]){
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst()==i-w) {
                qMax.pollFirst();
            }
            if(i>=w-1){
                result[index++] = arr[qMax.peekFirst()];
            }
        }

        return result;
    }
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
    //{4,2,5,6,3,1,2,4}, k = 3
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int partition(int[] array,int left,int right){
        int pivot = array[0];
        int L =left;
        int R =right;
        while(L<R){
            while (L<R&&array[R]>pivot){
                R--;
            }
            array[L] =array[R];
            while (L<R&&array[L]<=pivot){
                L++;
            }
            array[R] =array[L];

        }
        array[L] = pivot;
        return L;
    }

    public static int k(int[] array,int k){
        int index = partition(array,0,array.length-1);
        while (index!=k-1){
            if(index>k-1){
                index = partition(array,0,index-1);
            }else {
                index =partition(array,index+1,array.length-1);

            }
        }
        return array[index];
    }



}
