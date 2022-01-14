package com.cqyc.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: cqyc
 * @date 2022/1/13
 */
public class HasCycle141 {

    /**
     * 循环包含法
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> cycles = new HashSet<>();
        while(head != null) {
            if(cycles.contains(head)) {
                return true;
            }
            cycles.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleSlowQuick(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if(quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
