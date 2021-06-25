package com.test.all.altest.off;

import java.util.HashSet;

public class DFS {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rev(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while ( slow != null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode hasCycleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while ( slow != null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return null;
            }
        }
        return null;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int temp = nums[i];
            while (set.contains(--temp)) {
                count++;
                set.remove(temp);
            }
            temp = nums[i];
            while (set.contains(++temp)) {
                count++;
                set.remove(temp);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int cycleLength(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        int length =0;
        while ( fast != null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            length++;
            if (slow == fast) {
                return length;
            }
        }
        return length;
    }

    /**
     * 确定如环节点
     * 原理：把其中一个节点放到头节点，另一个节点放在相遇节点，他们都每次前进一步，相遇点即为入环节点
     * @param root
     * @param meetNode
     * @return
     */
    public static ListNode cycleNode(ListNode root,ListNode meetNode){
        //根节点
        ListNode p1 = root;
        //首次相遇节点
        ListNode p2 = meetNode;
        while (p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == p2){
                System.out.println("链表入环节点值为："+p1);
                return p1;
            }
        }
        return null;
    }



}
