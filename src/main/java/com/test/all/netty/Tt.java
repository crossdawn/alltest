package com.test.all.netty;

import java.util.Arrays;

public class Tt {
    public static void main(String[] args) {
        int[] array ={1,2,3,4,5,6,7,8,9};
        p("",array,5);
    }
    private static void p(String s ,int[] array,int n){
        if(n==1){
            Arrays.stream(array).forEach(x-> System.err.println(s+x));
        }
        for(int i =0;i<array.length;i++){
            String ss = "";
            ss = s+array[i];
            int index =0;
            int[] array2 = new int[array.length-1];
            for (int j=0;j<array.length;j++){
                if(j!=i){
                    array2[index++]= array[j];
                }
            }
            p(ss,array2,n-1);
        }
    }
}
