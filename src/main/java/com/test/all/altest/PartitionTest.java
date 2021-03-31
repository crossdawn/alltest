package com.test.all.altest;

import java.util.Arrays;

public class PartitionTest {
    public static void main(String[] args) {
        int[] array ={2,5,3,1,6};
        int l =0;
        int r=array.length-1;
        int pivoit = array[l];
        while (l<r){
            while (l<r&&array[l]<=pivoit){
                l++;
            }
            while (l<r&&pivoit<=array[r]){
                r--;
            }
            if(l<r){
                int temp =array[l];
                array[l] =array[r];
                array[r] =temp;
            }
            System.err.println("l:"+l+" r:"+r);
        }
        System.err.println(Arrays.toString(array));
    }
}
