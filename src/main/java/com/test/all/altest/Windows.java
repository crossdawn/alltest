package com.test.all.altest;

import java.util.LinkedList;

public class Windows {
    public static void main(String[] args){
    int[] arr = {4,3,5,4,3,3,6,7};
    printArray(getMaxWindow(arr,3));
}

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

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }



}
