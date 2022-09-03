package com.cqyc.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * @author cqyc
 * @create 2022-09-03-15:17
 */
public class StrIsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> oldMap = new HashMap<>();
        Map<Character, Integer> newMap = new HashMap<>();
        char[] oldChars = s.toCharArray();
        char[] newChars = t.toCharArray();
        for (int i = 0; i < oldChars.length; i++) {
            oldMap.put(oldChars[i], oldMap.getOrDefault(oldChars[i], 1) + 1);
        }
        for (int i = 0; i < newChars.length; i++) {
            newMap.put(newChars[i], newMap.getOrDefault(newChars[i], 1) + 1);
        }
        for (Map.Entry<Character, Integer> entry : oldMap.entrySet()) {
            if (!entry.getValue().equals(newMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

}
