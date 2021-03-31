package com.test.all.netty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        ListNode head5 = new ListNode(5);
        head1.next =head3;
        head3.next =head5;


        ListNode head2 = new ListNode(2);
        ListNode head4 = new ListNode(4);
        ListNode head6 = new ListNode(6);
        head2.next =head4;
        head4.next =head6;
       ListNode newhead= merge(head1,head2);
       while (newhead!=null){
           System.err.println(newhead.value);
           newhead=newhead.next;
       }
    }
    public static ListNode merge(ListNode head1,ListNode head2){
        ListNode head = head1.value<=head2.value?head1:head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head==head1?head2:head1;
        ListNode pre = head;
        while (cur1!=null&&cur2!=null){
            if(cur1.value<=cur2.value){
                pre.next = cur1;
                cur1 =cur1.next;
            }else {
                pre.next = cur2;
                cur2 =cur2.next;
            }
            pre=pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    private static int[][] merge(int[][] intervals) {
        //边界判断
        if (intervals.length <= 1) {
            return intervals;
        }

        //先按起点位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //利用list存储合并好的区间
        List<int[]> result = new ArrayList<>();
        //初始时将第一个区间放入list中
        result.add(intervals[0]);
        //记录上一合并好的区间在list中的位置
        int last = 0;
        //遍历并合并后面各区间
        for (int i = 1; i < intervals.length; i++) {
            //上一合并好的区间的起点和终点
            int lastStart = result.get(last)[0];
            int lastEnd = result.get(last)[1];
            //当前要合并的区间的起点和终点
            int start = intervals[i][0];
            int end = intervals[i][1];
            //如果左边重合
            if (lastStart == start) {
                if (end > lastEnd) {
                    result.set(last, new int[] {start, end});
                }

            } else {    //如果左边不重合
                if (start > lastEnd) {
                    result.add(new int[] {start, end});
                    last++;
                } else {
                    if (end > lastEnd) {
                        result.set(last, new int[] {lastStart, end});
                    }
                }
            }
        }

        return result.toArray(new int[0][]);
    }

//    private static int[] merge(int[]a,int[]b) {
//        int a1 = Math.min(a[0], b[0]);
//        int[] c = new int[a.length+b.length];
//        int ai = 0 ;
//        int bi=a1==a[0]?1:0;
////        while (){
////
////        }
//
//    }

}
