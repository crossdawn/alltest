package com.test.all.altest;

public class Seq {
    public static void main(String[] args) {
        int[] ia = {1, 2, 3, 4,5,6,7,8,9,10};
        int n = 5;
        System.out.println("排列结果 : ");
        permutation("",ia, n);
//	        System.out.println("组合结果 : ");
//	        combination(ia, n);
    }
    public static void permutation(String s, int[] ia, int n) {
        if(n == 1) {
            for(int i = 0; i < ia.length; i++) {
                System.out.println(s+ia[i]);
            }
        } else {
            for(int i = 0; i < ia.length; i++) {
                String ss = "";
                ss = s+ia[i]+"";
                //建立没有第i个元素的子数组
                int[] ii = new int[ia.length-1];
                int index = 0;
                for(int j = 0; j < ia.length; j++) {
                    if(j != i) {
                        ii[index++] = ia[j];
                    }
                }
                permutation(ss, ii, n-1);
            }
        }
    }
    public static void combination(int[] ia, int n) {
        combination("", ia, n);
    }
    public static void combination(String s, int[] ia, int n) {
        if(n == 1) {
            for(int i = 0; i < ia.length; i++) {
                System.out.println(s+ia[i]);
            }
        } else {
            for(int i = 0; i < ia.length-(n-1); i++) {
                String ss = "";
                ss = s+ia[i]+", ";
                //建立从i开始的子数组
                int[] ii = new int[ia.length-i-1];
                for(int j = 0; j < ia.length-i-1; j++) {
                    ii[j] = ia[i+j+1];
                }
                combination(ss, ii, n-1);
            }
        }
    }

}
