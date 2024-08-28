package com.cqyc.solution.arr;

/**
 * 两数相加
 *
 * @author cqyc
 * @create 2024-08-28-22:17
 */
public class 两数相加_2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        //取它的进制位
        int carry = 0;
        while(l1 != null || l2 != null) {
            //取总数
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            //取除位，大于10就为1，<10就为0
            carry = sum / 10;
            //取余位
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            //考虑最后进一位
            if(carry == 1) {
                cur.next = new ListNode(carry);
            }
        }

        return pre.next;

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
