package com.cqyc.solution.other;

/**
 * 删除链表的倒数第 n 个结点
 * @author cqyc
 * @create 2022-09-09-17:56
 */
public class RemoveNthFromEnd_21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = length(head);

        ListNode cur = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode res = dummy.next;
        return res;
    }

    public Integer length(ListNode node) {
        int index = 1;
        while (node != null) {
            index++;
            node = node.next;
        }
        return index;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



}
