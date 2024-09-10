package com.cqyc.solution.other;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author cqyc
 * @create 2022-10-19-10:07
 */
public class SplitHuiWenStr_131 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if(index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if(!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }

    }

    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while(left < right) {
            if(charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        SplitHuiWenStr_131 splitHuiWenStr_131 = new SplitHuiWenStr_131();
        List<List<String>> partition = splitHuiWenStr_131.partition(str);
        for (List<String> strings : partition) {
            strings.forEach(v -> {
                System.out.print(v + " ");
            });

            System.out.println("-----");
        }

        String strs = "penapplepenapple";
        int index = strs.indexOf("xxxxx");
        System.out.println(index);

    }

}
