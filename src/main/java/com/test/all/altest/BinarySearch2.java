package com.test.all.altest;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] array ={1,2,3,3,4,5};
        Integer a =1;
        a.notify();
        System.err.println(getLastK(array,3,0,array.length-1));
    }
    private static  int bs(int[] array ,int k ,int begin ,int end){
        if(begin > end){
            return -1;
        }
        int middle = (begin+end)/2;
        if(array[middle]==k){
            return middle;
        }else if(array[middle]>k){
            end = end-1;
        }else {
            begin =middle+1;
        }
        return bs(array,k,begin,end);
    }

    private static  int bs2(int[] array ,int k ,int begin ,int end){
        while (begin<=end) {
            int middle = (begin+end)/2;
            if(array[middle]==k){
                return middle;
            }else if(array[middle]>k){
                end = end-1;
            }else {
                begin =middle+1;
            }
        }
        return -1;
    }

    private static  int getFirstK(int[] array ,int k ,int begin ,int end){
        while (begin<=end) {
            int middle = (begin+end)/2;
            if(array[middle]==k){
                if((middle>0&&array[middle-1]!=k)||middle==0){
                    return middle;
                }else {
                   end =middle-1;
                }
            }else if(array[middle]>k){
                end = end-1;
            }else {
                begin =middle+1;
            }
        }
        return -1;
    }
    private static  int getLastK(int[] array ,int k ,int begin ,int end){
        while (begin<=end) {
            int middle = (begin+end)/2;
            if(array[middle]==k){
                if((middle<array.length-1&&array[middle+1]!=k)||middle==array.length-1){
                    return middle;
                }else {
                    begin =middle+1;
                }
            }else if(array[middle]>k){
                end = end-1;
            }else {
                begin =middle+1;
            }
        }
        return -1;
    }

}
