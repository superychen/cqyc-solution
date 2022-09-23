package com.cqyc.solution;

import java.util.Stack;

/**
 * @author cqyc
 * @create 2022-09-22-09:08
 */
public class MinStack_155 {

    Stack<stackFuzhu> stack;

    public MinStack_155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new stackFuzhu(val, val));
        } else {
            stack.push(new stackFuzhu(val, Math.min(val, getMin())));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }




    public class stackFuzhu {
        public int val;
        public int min;

        public stackFuzhu(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }


}
