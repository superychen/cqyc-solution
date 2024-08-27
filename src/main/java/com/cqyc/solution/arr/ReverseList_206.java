package com.cqyc.solution.arr;

/**
 * 反转链表
 * @Description:
 * @author: cqyc
 * @date 2022/1/11
 */
public class ReverseList_206 {

    //递归，让他的next.next指针反指向
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    //循环，把数据一个一个拿出来，然后在放进去prev中
    public ListNode reverseListFor(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ReverseList_206 test = new ReverseList_206();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        test.reverseListFor(node);
    }

}
