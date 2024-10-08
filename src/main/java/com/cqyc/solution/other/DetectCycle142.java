package com.cqyc.solution.other;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 环形链表 II
 * @author: cqyc
 * @date 2022/1/14
 */
public class DetectCycle142 {


    /**
     * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。
     * 随后，slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。
     * 如果链表中存在环，则 fast 指针最终将再次与 slow 指针在环中相遇。
     * 如下图所示，设链表中环外部分的长度为 aa。\slow 指针进入环后，又走了 bb 的距离与
     * fast 相遇。此时，fast 指针已经走完了环的 n 圈，
     * 因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nc。
     *根据题意，任意时刻，\textit{fast}fast 指针走过的距离都为 \textit{slow}slow 指针的 22 倍。因此，我们有
     *
     * a+(n+1)b+nc=2(a+b) \implies a=c+(n-1)(b+c)
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     * 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。
     * 最终，它们会在入环点相遇。
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if(fast == slow) {
                ListNode res = head;
                while(res != slow) {
                    slow = slow.next;
                    res = res.next;
                }
                return res;
            }
        }
        return null;
    }

    /**
     * 循环 + 哈希表完成
     */
    public ListNode detectCycleFor(ListNode head) {
        if(head == null) {
            return null;
        }
        Set<ListNode> res = new HashSet<>();
        while(head != null) {
            if(!res.contains(head)) {
                res.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
