package com.cqyc.solution.other;

/**
 * @author cqyc
 * @create 2022-09-09-16:15
 */
public class DeleteNode_237 {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
        next.next = node;
        node = next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        DeleteNode_237 test = new DeleteNode_237();
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(7);
        test.deleteNode(listNode);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }



}
