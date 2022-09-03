package com.cqyc.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author cqyc
 * @create 2022-09-03-14:37
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer res = map.get(chars[i]);
            if (res == null) {
                map.put(chars[i], i);
            } else {
                map.put(chars[i], -1);
            }
        }
        List<Integer> res = map.values().stream().filter(v -> v >= 0).sorted(Comparator.comparingInt(v -> v)).collect(Collectors.toList());
        return res.size() == 0 ? -1 : res.get(0);
    }

    public static void main(String[] args) {
        FirstUniqueCharacter test = new FirstUniqueCharacter();
        System.out.println(test.firstUniqChar("leetcode"));
    }

}
