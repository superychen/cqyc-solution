package com.cqyc.solution.other;

import java.util.*;

/**
 * 单词拆分2
 *
 * @author cqyc
 * @create 2022-10-20-14:34
 */
public class WordBreak2_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> backtrack = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> res = new LinkedList<>();
        for (List<String> list : backtrack) {
            res.add(String.join(" ", list));
        }
        return res;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> workBreaks = new LinkedList<>();
            if (index == length) {
                workBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWorkBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWorkBreak : nextWorkBreaks) {
                        LinkedList<String> workBreak = new LinkedList<>(nextWorkBreak);
                        workBreak.offerFirst(word);
                        workBreaks.add(workBreak);
                    }

                }
            }
            map.put(index, workBreaks);
        }
        return map.get(index);
    }

    public static void main(String[] args) {
        WordBreak2_140 wordBreak2_140 = new WordBreak2_140();
        wordBreak2_140.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
        String str = "abcd";
        System.out.println(str.substring(0, 3));
        System.out.println(str.substring(1, 3));

    }

}
