package com.cqyc.solution.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * arr这个目录下面放高频面试题吧
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * @author cqyc
 * @create 2024-08-18-10:34
 */
public class LengthOfLongestSubstring_3 {

    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 最傻逼的办法
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                char jChar = chars[j];
                if(jChar == ' ') {
                    set.add(jChar);
                }
                if(set.contains(jChar)) {
                    res = Math.max(set.size(), res);
                    set.clear();
                    break;
                }
                set.add(jChar);
            }

        }
        return res;
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk < n && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(rk - i, ans);
        }
        return ans;
    }

        public static void main(String[] args) {
//        String a = "abcabcbb";
        String a = " ";
        LengthOfLongestSubstring_3 test = new LengthOfLongestSubstring_3();
        System.out.println(test.lengthOfLongestSubstring2(a));
    }


}
