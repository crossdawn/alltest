package com.test.all.jdk;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) throws Exception {
        AtomicInteger a = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            while (incr(a)) {

            }
        }, "A");
        t1.start();
        Thread t2 = new Thread(() -> {
            while (incr(a)) {

            }        }, "B");
        t2.start();
        Thread t3 = new Thread(() -> {
            while (incr(a)) {

            }        }, "C");
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.err.println(a.get());

    }

    private static boolean incr(AtomicInteger a) {
//        try{
//            Thread.sleep(10);
//
//        }catch (Exception e){}
        int i = a.get();
        if (i >= 200) {
            return false;
        }
        if (a.compareAndSet(i, i + 1)) {
           System.out.println(Thread.currentThread().getName() + "成功+1");
            return true;
        }
        System.err.println(Thread.currentThread().getName() + "重试");
        return incr(a);
    }

    public static void heapInsert(int[] array,int i){
        int cur  = i;
        int parent = (i-1)/2;
        while (array[cur]>array[parent]){
            swap(array,cur,parent);
            cur = parent;
            parent = (cur-1)/2;
        }
    }
    public static void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void heapify(int[] array,int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int index = i;
        while (array[index]>array[left]){
            int large = 0;
            if(array[left]>array[right]){
                large = left;
            }else {
                large = right;
            }
            if(array[index]>array[large]){
                large = index;
            }
            if(index==large){
               break;
            }
            swap(array,index,large);
            index = large;
            left = 2*large+1;
                    right =  2*large+2;
        }
    }

}
