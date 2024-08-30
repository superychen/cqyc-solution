package com.cqyc.solution.arr;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: CQYC
 * @date: 2024-08-29-11:33
 */
public class Test_01 {

    public static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean test(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if(map.containsKey(aChar)) {
                if(stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if(peek == map.get(aChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String testStr = "({})";
        Test_01 test = new Test_01();
        System.out.println(test.test(testStr));
    }
}
