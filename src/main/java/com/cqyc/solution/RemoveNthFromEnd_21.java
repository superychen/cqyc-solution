package com.cqyc.solution;

/**
 * @author cqyc
 * @create 2022-09-09-17:56
 */
public class RemoveNthFromEnd_21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int index = length(head);

        for (int i = 0; i < index; i++) {

        }
        while(node != null) {
            if(n == --index) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return node;
    }

    public Integer length(ListNode node) {
        int index = 0;
        while (node != null) {
            index++;
            node = node.next;
        }
        return index;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



}
