package com.test.all.altest.link;

public class LinkReverse3 {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre =null;
        ListNode cur =head;
        while (cur!=null){
            ListNode next =cur.next;
            cur.next=pre;
            pre =cur;
            cur =next;
        }
        return pre;
    }

    /**
     * 两两交换
     * @param head
     * @return
     */
    public static ListNode reversePairs(ListNode head){
        ListNode tempHead =new ListNode(-1);
        tempHead.next =head;
        ListNode temp = tempHead;
        //1 2 3 4 5
        while (temp.next!=null&&temp.next.next!=null){
            ListNode node1 =temp.next;
            ListNode node2 =temp.next.next;
            temp.next=node2;
            node1.next =node2.next;
            node2.next =node1;
            temp =node1;
        }
        return tempHead.next;
    }
    /**
     * 反转部分
     * @param head
     * @return
     */
    public static ListNode reverseSub(ListNode head,int left,int right){
        ListNode tempHead =new ListNode(0);
        tempHead.next=head;
        ListNode pre=tempHead;
        for(int i=1;i<left;i++){
            pre =pre.next;
        }
        ListNode cur =pre.next;
        ListNode next;
        // 1 2 3 4 5
        for (int i=0;i<right-left;i++){
            next =cur.next;
            cur.next =next.next;
            next.next = pre.next ;
            pre.next =next;
        }
        return tempHead.next;
    }
    /**
     * K个一组反转
     * @param head
     * @return
     */
    public static ListNode reverseK(ListNode head,int k){
        ListNode tempHead =new ListNode(-1);
        tempHead.next=head;

        ListNode pre =tempHead;
        ListNode begin =tempHead.next;
        ListNode end =null;
        ListNode pNext =null;

        while (begin!=null){
            end =begin;
            for(int i=1;i<k;i++){
                if(end.next!=null){
                    end =end.next;
                }else {
                    return tempHead.next;
                }
            }
            pNext = end.next;//下一部分
            end.next =null;
            ListNode newHead = reverse(begin);
            pre.next =newHead;
            begin.next =pNext;
            pre =begin;
            begin =pNext;
        }
        return tempHead;
    }

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
        ListNode newHead = reverseSub(head,2,3);
//        ListNode newHead = reverList(head);
        while (newHead!=null){
            System.err.println(newHead.val);
            newHead =newHead.next;
        }
        for(int i=1;i<1;i++){
            System.err.println(2);
        }
    }
}
