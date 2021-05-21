package com.test.all.netty;

public class LxTest {
    public static void main(String args[]) {
        String str="12345";
        allContinuousSubArray(str);

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
