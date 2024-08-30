package com.cqyc.solution.arr;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class 反转链表2_92 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 穿针引线(sb官方做的)
     * 大佬用的双指针加头插法-叼
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //定义一个dummyHead,方便处理
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        //将指针移到相应位置
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            p = p.next;
        }

        //头插法插入节点
        for (int i = 0; i < right - left; i++) {
            //第一次循环 removed = 3 -> 4 -> 5
            ListNode removed = p.next;
            //这一步把3剔出去，p = 2 -> 4 -> 5
            p.next = p.next.next;

            //remove改变，3 -> 4 -> 5 改为 3 -> 2 -> 4 -> 5
            removed.next = g.next;
            //g.next 就等于 1 -> 3 -> 2 -> 4 -> 5
            //然后下一次循环，直接把他next放到最前面即可
            g.next = removed;
        }
        return dummyHead.next;

    }

    public ListNode reverseBetweenTest(ListNode head, int left, int right) {
        //测试方法写在这
        return null;
    }

    public static void main(String[] args) {
        反转链表2_92 test = new 反转链表2_92();
        反转链表2_92.ListNode node = new 反转链表2_92.ListNode(1);
        node.next = new 反转链表2_92.ListNode(2);
        node.next.next = new 反转链表2_92.ListNode(3);
        node.next.next.next = new 反转链表2_92.ListNode(4);
        node.next.next.next.next = new 反转链表2_92.ListNode(5);
        test.reverseBetween(node, 2, 4);
    }

}
