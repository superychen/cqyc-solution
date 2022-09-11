package com.cqyc.solution;

/**
 * @author cqyc
 * @create 2022-09-09-15:31
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[strs.length - 1];
        }
        int index = 1;
        return prefixStr(index, strs);
    }

    private String prefixStr(int index, String[] strs) {
        if(index >= strs.length) {
            return strs[index - 1];
        }
        strs[index] = getSamePrefix(strs[index - 1], strs[index]);
        return prefixStr(++index, strs);
    }

    private String getSamePrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                builder.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 test1 = new LongestCommonPrefix_14();
//        String[] strs = new String[]{"flower", "rfxlow", "qfwlight"};
        String[] strs = new String[]{"cir","car"};
        System.out.println(test1.longestCommonPrefix(strs));
    }

}
