package com.test.all.jdk.collection;

import java.util.ArrayList;

public class SublistTest {
    public static void main(String args[]) {
        int[] a= {1,2,3};
        ArrayList<ArrayList<Integer>> list=getSubArray(a,a.length);
        //输出列表：
        for (int i=0;i<list.size();i++) {
            ArrayList<Integer> mList=list.get(i);
            for (int j=0;j<mList.size();j++) {
                System.out.print(mList.get(j)+" ");
            }
            //换行
            System.out.println();

        }
    }

    private static ArrayList<ArrayList<Integer>> getSubArray(int[] arr,int length) {
        ArrayList<ArrayList<Integer>> bList=new ArrayList<>();
        int mark=0;
        int nEnd=1<<length;
        boolean bNullset=false;
        for (mark=0;mark<nEnd;mark++) {
            ArrayList<Integer> aList=new ArrayList<>();
            bNullset=true;
            for (int i=0;i<length;i++) {
                if (((1<<i)&mark)!=0) {
                    bNullset=false;
                    aList.add(arr[i]);
                }
            }
            bList.add(aList);
        }
        return bList;
    }

}
