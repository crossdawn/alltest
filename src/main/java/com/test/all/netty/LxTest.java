package com.test.all.netty;

import java.util.ArrayList;
import java.util.List;

public class LxTest {
    public static void main(String args[]) {
        String str="12345";
        allContinuousSubArray(str);

    }
    private static void perm(int[] array, int index, List<String> sub,List<List<String>> result) {
       if(index ==array.length){
           result.add(new ArrayList<>(sub));
       }else {
           for(int i =index;index<array.length;i++){
               if(!sub.contains(array[index]+"")){
                   sub.add(array[index]+"");
                   perm(array,index+1,sub,result);
                   sub.remove(sub.size()-1);
               }
           }
       }
    }

    private static void allContinuousSubArray(String str) {
        int i,j,k;
        int num=str.length();
        for (i=0;i<num;i++) {
            for (j=i;j<num;j++) {
                for (k=i;k<=j;k++) {
                    System.out.print(str.charAt(k)+" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static void allContinuousSubArray2(String str) {
        int i,j,k;
        int num=str.length();
        for (i=0;i<num;i++) {
            for (j=i;j<num;j++) {
                for (k=i;k<=j;k++) {
                    System.out.print(str.charAt(k)+" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
