package com.test.all.altest;

public class NodeTest {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }

      }
    private static ListNode rev3(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp =head.next;
        ListNode newHead = rev3(head.next);
        temp.next=head;
        head.next =null;
        return newHead;
    }

      private static ListNode rev2(ListNode head){
          if(head==null||head.next==null){
              return head;
          }
          ListNode pre = null;
          ListNode cur =head;
          while (cur.next!=null){
              ListNode temp =cur.next;
              cur.next =pre;
              pre =cur;
              cur = temp;
          }
          return pre;
      }

      private static ListNode rev(ListNode head){
          if(head==null||head.next==null){
              return head;
          }
          ListNode pre =null;
          ListNode cur =head;
          ListNode next =head.next;
          while (next!=null){
              cur.next =pre;
              pre=cur;
              cur =next;
              next =cur.next;
          }
          return pre;
      }
     private static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp =head.next;
        ListNode newHead = reverse(temp);
        temp.next =head;
        head.next =null;
        return newHead;
//        {}
//            return head;
//        ListNode temp = head.next;//保存下一个节点
//        ListNode newHead = reverse(head.next);//整体思维，宏观语义
//        temp.next = head;//连上头与递归部分
//        head.next = null;//调整尾部
//        return newHead;//返回头节点
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode head = listNode1;
        while (head!=null){
            System.err.println(head.val);
            head = head.next;
        }
        ListNode newHead = rev3(listNode1);
        while (newHead!=null){
            System.err.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
