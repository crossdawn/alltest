package com.test.all.altest.link;

public class RemDu {


    // 0 1 23 3
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tem = new ListNode(0);
        tem.next =head;
        ListNode cur = tem;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x =cur.next.val;
                while (cur.next!=null&&x==cur.next.val){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return tem.next;
    }

}

