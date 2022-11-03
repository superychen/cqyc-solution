package com.cqyc.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author cqyc
 * @create 2022-09-26-10:14
 */
public class ValidParentheses_20 {

    public static final Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty()) {
                Character peek = stack.peek();
                Character character = map.get(peek);
                if(character != null && c == character) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses_20 validParentheses_20 = new ValidParentheses_20();
        System.out.println(validParentheses_20.isValid("({[)"));
    }

}
