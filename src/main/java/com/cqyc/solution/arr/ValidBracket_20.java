package com.cqyc.solution.arr;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * @author: CQYC
 * @date: 2024-08-26-8:41
 */
public class ValidBracket_20 {

    public static final Map<Character, Character> map = new HashMap<>(3);
    static {
//        map.put('(', ')');
//        map.put('{', '}');
//        map.put('[', ']');
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            Character value = map.get(aChar);
            if (value == null || stack.isEmpty()) {
                stack.push(aChar);
                continue;
            }
            Character peek = stack.peek();
            if (peek == value) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]}{";
        ValidBracket_20 test = new ValidBracket_20();
        System.out.println(test.isValid(s));
    }

}
