package com.test.all.altest;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] a ={1,3,2,0,5};
        System.err.println(Arrays.toString(a));
        quick(a,0,a.length-1);
        System.err.println(Arrays.toString(a));
    }
    private static void bsort(int[] a){
        for(int i =1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                  int temp =a[j];
                  a[j]=a[j+1];
                  a[j+1]=temp;
                }
            }
        }
    }

    private static void quick(int[] a,int low,int high){
        if (low >= high) {return;};
        int p = partion(a,low,high);
        quick(a,low,p-1);
        quick(a,p+1,high);
    }

    private static int partion(int[] a,int low,int high){
        int pivot = a[low];
        while (low<high){
            while (low<high&&a[high]>=pivot){
                high--;
            }
            a[low]=a[high];
            while (low<high&&a[low]<=pivot){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=pivot;
        return low;
    }

}
