package com.cqyc.solution.other;

import java.util.Stack;

/**
 * //I             1
 * //V             5
 * //X             10
 * //L             50
 * //C             100
 * //D             500
 * //M             1000
 * @author cqyc
 * @create 2022-09-23-10:44
 */
public class RomanToInt_13 {

    public int romanToInt(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int intRoman = getIntRoman(c);

            if(i != 0) {
                char prefix = s.charAt(i - 1);
                int prefixIntRoman = getIntRoman(prefix);
                if(prefixIntRoman < intRoman) {
                    intRoman = intRoman - (2 * prefixIntRoman);
                }
            }
            res += intRoman;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "VI";
        RomanToInt_13 romanToInt_13 = new RomanToInt_13();
        System.out.println(romanToInt_13.romanToInt(str));
    }

    public int getIntRoman(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("param is error!");
        }
    }

}
