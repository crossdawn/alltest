package com.test.all.altest;

/**
 * 二分法查找
 * 因为有序 所以二分
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {-1, 3, 3, 4, 5};
        System.err.println(bsearch(array, 3));
        System.err.println(bsearch2(array, 3,0,array.length-1));
    }

    public static int bsearch(int[] array, int key) {
        int L = 0;
        int R = array.length - 1;
        if (key < array[L] || key > array[R]) {
            return -1;
        }
        while (L <= R) {
            int M = (L + R) / 2;
            if (key > array[M]) {
                L = M + 1;
            } else if (key < array[M]) {
                R = M - 1;
            } else {
                return M;
            }
        }
        return -1;
    }

    public static int bsearch2(int[] array,int key,int L,int R){
        if (key < array[L] || key > array[R]) {
            return -1;
        }
        int M = (L+R)/2;
        if(array[M]==key){
           return M;
        }else if(array[M]<key){
            return bsearch2(array,key,M+1,R);
        }else {
            return bsearch2(array,key,L,M-1);
        }
    }


//    public static int bsearch2(int[] array,int key,int L,int R){
//        if(key<array[L]||key>array[R]){
//            return -1;
//        }
//
//        while (L<=R){int M =(L+R)/2;}
//    }

}

