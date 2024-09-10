package com.cqyc.solution.other;

import java.util.*;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//
//
//
// 示例 1：
//
//
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//
//
// 示例 2：
//
//
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
//
//
// 示例 3：
//
//
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s 和 wordDict[i] 仅有小写英文字母组成
// wordDict 中的所有字符串 互不相同
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1840 👎 0
/**
 * 单词拆分
 * @author cqyc
 * @create 2022-10-19-15:45
 */
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(res[j] && set.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }


    public static void main(String[] args) {
        WordBreak_139 wordBreak_139 = new WordBreak_139();
//        boolean b = wordBreak_139.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb"));
//        boolean b = wordBreak_139.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
//        boolean b = wordBreak_139.wordBreak("leetcode", Arrays.asList("leet", "code"));
//        boolean b = wordBreak_139.wordBreak("applepenapplexxxx", Arrays.asList("apple", "pen"));
        boolean b = wordBreak_139.wordBreak("abcd", Arrays.asList("a","abc","b","cd"));

        System.out.println("b = " + b);

        String str = "abcd";
        System.out.println(str.substring(0, 3));
        System.out.println(str.substring(1, 3));

    }

}
