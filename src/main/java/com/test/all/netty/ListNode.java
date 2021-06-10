package com.test.all.netty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

        ListNode head2 = new ListNode(2);
        ListNode head4 = new ListNode(4);
        ListNode head6 = new ListNode(6);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        ListNode newhead = revv(head1,1,1);

//        head2.next = head4;
//        head4.next = head6;
//        ListNode newhead = merge2(head1, head2);
////        System.err.println(mid(newhead).value);
//        System.err.println(cycle(newhead));
//        ListNode newhead =rev(head1);
        while (newhead != null) {
            System.err.println(newhead.value);
            newhead = newhead.next;
        }
    }

    private void incr(AtomicInteger a) {
        int i = a.get();
        if (i >= 100) {
            return;
        }
        if (a.compareAndSet(i, i + 1)) {
            incr(a);
        }
    }

    public static ListNode merge(ListNode head1, ListNode head2) {

        ListNode head = head1.value <= head2.value ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static ListNode merge3(ListNode head1, ListNode head2) {
        ListNode head = head1.value > head2.value ? head1 : head2;
        ListNode cur1 = head == head1 ? head1.next : head2.next;
        ListNode cur2 = head == head1 ? head1.next : head2.next;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                pre.next = cur1;
                pre = cur1;
                cur1 = cur1.next;
            } else {

            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static ListNode merge2(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return newHead.next;
    }

    //null-5-4-6-2-1
    public static ListNode quick(ListNode begin, ListNode end) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = new ListNode(0);
        int pivot = begin.value;
        ListNode lhead = begin;
        ListNode utail = begin;
        ListNode cur = begin.next;

        return newHead.next;
    }

    public static void mergeSort(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return;
        }
        ListNode mid = mid(listNode);
        mergeSort(listNode);
        mergeSort(mid);
        merge(listNode, mid);
    }

    public static boolean cycle(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && slow != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static ListNode mid(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode rev(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static ListNode rev2(ListNode head) {
        ListNode pre =null;
        ListNode cur =head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next =pre;
            pre =cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode revv(ListNode head, int from, int to) {
        ListNode head2 = null;
        ListNode head3 = null;
        //1 2 3 4 5 6
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == from - 1) {
                head2 = temp;
            }
            if (count == to + 1) {
                head3 = temp;
            }
            temp = temp.next;
        }
        if(from>to||from<1||to>count){
            return null;
        }
//        //
//        ListNode newHead2 = null;
//        if (head2 == null) {
//            newHead2 = head;
//        } else {
//            newHead2 = head2.next;
//        }
//
//        ListNode pre = head3;
//        ListNode cur = newHead2;
//        while (cur != head3) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        if (head2 == null) {
//            return pre;
//        }
//        head2.next = pre;
        ListNode newHead2 = null;
        if(head2==null){
            newHead2 =head;
        }
        ListNode pre =head3;
        ListNode cur = newHead2;
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
                    result.set(last, new int[]{start, end});
                }

            } else {    //如果左边不重合
                if (start > lastEnd) {
                    result.add(new int[]{start, end});
                    last++;
                } else {
                    if (end > lastEnd) {
                        result.set(last, new int[]{lastStart, end});
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
    static class Solution {
        public static ListNode sortList(ListNode head) {
            return quickSort(head, null);
        }

        public static ListNode quickSort2(ListNode head, ListNode end) {
            if (head == end || head.next == end) {
                return head;
            }
            ListNode lhead = head, tail = head, p = head.next;
            while (p.next != null) {
                ListNode next = p.next;
                if (p.value < head.value) {
                    p.next = lhead;
                    lhead = p;
                } else {
                    tail.next = p;
                    tail = p;
                }
                p = next;
            }
            tail.next = end;
            ListNode node = quick(lhead, head);
            head.next = quick(head.next, tail);
            return node;
        }

        public static ListNode quickSort(ListNode head, ListNode end) {
            if (head == end || head.next == end) {
                return head;
            }
            ListNode lhead = head, utail = head, p = head.next;
            while (p != end) {
                ListNode next = p.next;
                if (p.value < head.value) {//头插
                    p.next = lhead;
                    lhead = p;
                } else { //尾插
                    utail.next = p;
                    utail = p;
                }
                p = next;
            }
            utail.next = end;

            ListNode node = quickSort(lhead, head);
            head.next = quickSort(head.next, end);
            return node;
        }

        public static void main(String[] args) {
            ListNode listNode5 = new ListNode(5);
            ListNode listNode3 = new ListNode(3);
            ListNode listNode2 = new ListNode(2);
            ListNode listNode1 = new ListNode(1);
            listNode5.next = listNode3;
            listNode3.next = listNode2;
            listNode2.next = listNode1;
            quickSort(listNode5, null);


        }
    }


}
