package com.test.all.altest.link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkSort {
    public static int [] random_order_array(int len){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i ++){
            list.add(i);
        }
        Collections.shuffle(list);
        int [] array = new int [len];
        for (int i = 0; i < len; i ++)
            array[i] = list.get(i);
        return array;
    }

    public static void print_mynode(MyNode node, int len){
        MyNode temp = node;
        for (int i = 0; i < len; i ++){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void quiksort(MyNode start_pre, int len, MyNode end){
        if (len <= 1)
            return;
        MyNode start = start_pre.next;
        int pivot_val = start.val;
        int split_position = 0;

        MyNode temp0 = start;
        MyNode temp1 = start.next;
        for (int i = 1; i < len; i ++){
            if (temp1.val > pivot_val){ //放到链表末尾
                if (temp1 != end){
                    temp0.next = temp1.next;
                    temp1.next = end.next;
                    end.next = temp1;
                    end = temp1;
                    temp1 = temp0.next;
                }
            }
            else{
                temp1 = temp1.next;
                temp0 = temp0.next;

                split_position ++;
            }
        }
        MyNode pivot_node = start;
        if (temp0 != start){
            start_pre.next = pivot_node.next;
            temp0.next = pivot_node;
            pivot_node.next = temp1;
        }
        quiksort(start_pre, split_position, temp0);
        quiksort(pivot_node, len - split_position - 1, end);
    }


    public static void main(String [] args){

        int len = 20;
        int [] array = random_order_array(len);
        //int [] array = {0, 3, 2, 8, 6, 9, 7, 5, 1, 4 };
        //int [] array = {3, 2, 8, 6, 9, 7, 5, 1, 4  };
        MyNode start = new MyNode(array[0]);
        MyNode temp = start;
        for (int i = 1; i < array.length; i ++){
            temp.next = new MyNode(array[i]);
            temp = temp.next;
        }
        MyNode end = start;
        for (int i = 0; i < len - 1; i ++){
            end = end.next;
        }
        MyNode start_pre = new MyNode(-1);
        start_pre.next = start;
        System.out.println("乱序数组：");
        print_mynode(start_pre.next, len);
        quiksort(start_pre, len, end);
        System.out.println("排序后数组：");
        print_mynode(start_pre.next, len);
    }

   static class MyNode{
        int val;
        MyNode next = null;
        public MyNode(int val){
            this.val = val;
        }
    }
}
