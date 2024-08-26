package com.cqyc.solution.arr;


/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串（如果字符串向前和向后读都相同，则它满足 回文性）
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome_05 {

    /**
     * 双指针不可行
     * 先用暴力破解，会超出时间限制，因为O（N^2）
     */
    public String longestPalindrome(String s) {
        String res = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                String subStr = s.substring(i, j);
                if(isCompactStr(subStr) && subStr.length() > res.length()) {
                    res = subStr;
                }
            }
        }
        return res;
    }

    /**
     * 判断前后反转两个字符串是否相等
     */
    private boolean isCompactStr(String str) {
        int l = 0;
        int r = str.length() - 1;
        while(l < str.length() - 1 && r >= 0) {
            if(str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public String longestPalindrome_1(String s) {
        if ("".equals(s)) {
            return "";
        }
        int length = s.length();
        //先反转列表
        String reverse = new StringBuilder(s).reverse().toString();
        //为了求最长公共子串，就需要定义一个二维数组
        int[][] resInt = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //如果这两个相等
                if (s.charAt(i) == reverse.charAt(j)) {
                    //第一个if是为了处理数组下标漏出的问题
                    if(i == 0 || j == 0) {
                        resInt[i][j] = 1;
                    } else {
                        //这里就是对应子串中连续的继续+1
                        resInt[i][j] = resInt[i - 1][j - 1] + 1;
                    }

                    /**********修改的地方*******************/
                    //以i下标为结尾
//                    if(resInt[i][j] > maxLen) {
//                        maxLen = resInt[i][j];
//                        maxEnd = i;
//                    }
                    if (resInt[i][j] > maxLen) {
                        int beforeRev = length - 1 - j;
                        if (beforeRev + resInt[i][j] - 1 == i) { //判断下标是否对应
                            maxLen = resInt[i][j];
                            maxEnd = i;
                        }
                    }
                    /*************************************/


                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);

    }

    public static void main(String[] args) {
        LongestPalindrome_05 test = new LongestPalindrome_05();
        String str = "ab";
        String s = test.longestPalindrome(str);
        System.out.println("s = " + s);
    }

}
