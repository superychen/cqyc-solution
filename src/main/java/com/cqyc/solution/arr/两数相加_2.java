package com.cqyc.solution.arr;

/**
 * 两数相加
 *
 * @author cqyc
 * @create 2024-08-28-22:17
 */
public class 两数相加_2 {


    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode prev = cur;
        //给一个进制位
        int carry = 0;
        while(l1 != null || l2 != null) {
            //计算和
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            //计算个位和十位,个位只会存在0和1
            carry = sum / 10;
            //十位就是加的和
            sum = sum % 10;

            prev.next = new ListNode(sum);
            prev = prev.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            prev.next = new ListNode(carry);
        }
        return cur.next;
    }

    public class ListNode {
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

}
