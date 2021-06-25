package com.test.all.altest;


import java.util.Arrays;

/**
 * 二叉堆
 * @param <E>
 */
public class BinaryHeap<E> {
    public static void main(String[] args) {
        Integer[] array = {1,2,34,5,6,0};
        build_heap(array,6);
        System.err.println(Arrays.toString(array));
    }
      /**@desc 说明1 heapfy 方法
      * @param i : 表示对那个节点进行堆的heapify
       * @param h : 表示堆的节点个数
       */
              public static void heapfiy(Integer[] arr, int i, int h){
                 //1、计算树的节点个数,减1代表下标
                 int n = h;

                //递归需要定义一个出口
                 if(i >= (n-2)/2){
                       return;
                     }
                 //计算 i 的左子树和右子树
                int c1 = i * 2 + 1;
                 int c2 = i * 2 + 2;
                 int max = i;
                 //判断左子树是否大于 max 下标的值
                 if(c1 < n && arr[c1] > arr[max] ){
                         max = c1;
                     }

                 //判断右子树是否大于 max 下标的值
                 if(c2 < n && arr[c2] > arr[max] ){
                         max = c2;
                     }

                 //如果 i == max 说明就是堆，否则就递归 heapfiy 调用
                 if(max != i){
                         swap(arr,max,i);
                         heapfiy(arr,max,h);
                    }
             }

             //说明2: 数组到序递归 heapify，从最后一个节点的parent;
             public static void build_heap(Integer arr[],int n){
                 //确定最后一个节点的父节点
                 int parent = (n - 2) / 2;
                 //由下向上堆排序
                 for(int i = parent; i >= 0; i--){
                         heapfiy(arr,i,n);
                 }
             }

             //数据交换
             public static void swap(Integer[] arr,int i,int n){
                 int temp ;
                 temp = arr[i];
                 arr[i] = arr[n];
                 arr[n] = temp;
            }

}
