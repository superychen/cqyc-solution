package com.cqyc.solution.other;

/**
 * @Description: 两两交换链表中的节点
 * @author: cqyc
 * @date 2022/1/12
 */
public class SwapPairsList24 {

    //循环交换连标节点
    public ListNode swapPairs(ListNode head) {
        //要有一个空节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
    
    
    public ListNode swapPairsDG(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairsDG(newNode.next);
        newNode.next = head;
        return newNode;
    }

    public static void main(String[] args) {
        SwapPairsList24 test = new SwapPairsList24();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        test.swapPairsDG(node);
        
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
