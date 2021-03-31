package com.test.all.altest;

public class NodeListTest {
    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        // 判断链表中元素的个数
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
            // k - 1是因为next到了k个
            if(count == k - 1){
                break;
            }
        }
        // 如果当前temp的下一个节点为空，说明个数不够k，则直接返回
        if(current == null){
            return head;
        }

        int num = k;       // 保存翻转的次数
        ListNode tempHead = head;  // 保存递归后连接的头结点
        // 翻转链表
        ListNode pre = null;
        while(num > 0){
            // 在head的next指针断开前，先保存它的next指针指向的对象
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            num--;
        }
        // current.next为下一次翻转的头结点
        current = current.next;
        tempHead.next = reverseKGroup(current, k);
        return pre;
    }


}
