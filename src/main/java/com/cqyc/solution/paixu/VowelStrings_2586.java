package com.cqyc.solution.paixu;

import java.util.HashSet;
import java.util.Set;

/**
 * 统计范围内的元音字符串数
 * 给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right 。
 *
 * 如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串 ，其中元音字母是 'a'、'e'、'i'、'o'、'u' 。
 *
 * 返回 words[i] 是元音字符串的数目，其中 i 在闭区间 [left, right] 内。
 */
public class VowelStrings_2586 {

    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if(i < left) {
                continue;
            }
            if(i > right) {
                break;
            }
            char[] chars = words[i].toCharArray();
            int length = words[i].length();
            char first = chars[0];
            char end = chars[length - 1];
            if (set.contains(first) && set.contains(end)) {
                ans++;
            }
        }
        for (String word : words) {

        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"hey","aeo","mu","ooo","artro"};
        VowelStrings_2586 test = new VowelStrings_2586();
        int i = test.vowelStrings(str, 1, 4);
        System.out.println("i = " + i);
    }

}
