package com.test.all.altest.link;

import java.util.List;

/**
 * 判断回文链表
 */
public class Huiwen {
    //1 2 2 1
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow =head;
        while (fast.next!=null){
            fast =fast.next.next;
            slow =slow .next;
        }
         fast =slow;
         slow =head;
        while (fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true ;
    }
}
