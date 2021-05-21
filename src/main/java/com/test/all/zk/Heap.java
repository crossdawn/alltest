package com.test.all.zk;

public class Heap {
    public void heapInsert(int[] array){
        for(int i=0;i<array.length;i++){
            int cur =i;
            int father = (i-1)/2;
            while (array[cur]<array[father]){
                swap(array,cur,father);
                cur =father;
                father =(cur-1)/2;
            }
        }
    }

    public void heapInsert2(int[] array){
        for(int i=0;i<array.length;i++){
           int cur =i;
           int father =(i-1)/2;
           while (array[cur]<array[father]){
               swap(array,cur,father);
               cur =father;
               father = (cur-1)/2;
           }
        }
    }
public void swap2(int[] array,int a ,int b){
        int temp =array[a];
        array[a] =array[b];
        array[b]=temp;
}
    public void heapfy(int[] array,int index,int size){
//        int left =
    }

    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
