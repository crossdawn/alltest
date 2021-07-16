package com.test.all.altest;

import com.test.all.netty.ListNode;
import com.test.all.way.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeArea {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {1, 3}, {3, 5}, {4, 6}, {7, 9}};
        Arrays.stream(merge(intervals)).forEach(x -> System.err.println(Arrays.toString(x)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] < end) {
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }
            result.add(new int[]{begin, end});
        }
        return result.toArray(new int[][]{});
    }

//    public ListNode rem(ListNode head,int k){
//        ListNode temp = new ListNode(0);
//        temp.next = head;
//        ListNode first =head;
//        ListNode second =temp;
//        while (k>0){
//            first = first.next;
//            k--;
//        }
//        while (first!=null){
//            first =first.next;
//            second =second.next;
//        }
//        second.next = second.next.next;
//        return temp.next;
//    }


}
