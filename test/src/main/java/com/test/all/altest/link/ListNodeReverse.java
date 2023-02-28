package com.test.all.altest.link;

import java.util.LinkedList;

public class ListNodeReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        head.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next =listNode4;
        listNode4.next =listNode5;
        print(head);
        ListNode newHead = reverse1(head);
        print(newHead);
        System.err.println(Float.MAX_VALUE);
    }

    public static ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode cur =head;
        while (cur!=null){
            ListNode temp= cur.next;
            cur.next =pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverse1(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode next =null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode delK(ListNode head,int k){
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next =head;
        ListNode first = temp;
        ListNode second =head;
        while (k>0){
            first = first.next;
            k--;
        }
        return head;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow =head;
        while (true){
            if(fast==null||fast.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next.next;
            if(fast ==slow){
                break;
            }
        }
        fast = head;
        while (fast!=slow){
            fast= fast.next;
            slow =slow .next;
        }
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast =fast.next.next;
            slow =slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }


    public static void print(ListNode head){
        StringBuilder sb = new StringBuilder();
        ListNode print =head;
        while (print!=null){
            sb.append(print.val);
            print =print.next;
        }
        System.err.println(sb.toString());
    }

    public boolean canReach2nd(int[] arr, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.removeFirst();
                int curValue = arr[curPos];
                if (curValue == 0) return true;
                int leftPos = curPos - curValue;
                if (leftPos >= 0 && !visited[leftPos]) {
                    visited[leftPos] = true;
                    queue.addFirst(leftPos);
                }
                int rightPos = curPos + curValue;
                if (rightPos < n && !visited[rightPos]) {
                    visited[rightPos] = true;
                    queue.addFirst(rightPos);
                }
            }
        }
        return false;
    }


}
