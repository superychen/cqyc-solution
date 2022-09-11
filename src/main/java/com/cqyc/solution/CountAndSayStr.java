package com.cqyc.solution;

/**
 * 外观数列
 */
public class CountAndSayStr {

    public String countAndSay(int n) {
        int nIndex = 1;
        String beginStr = "1";
        return countAndSayDg(nIndex, n, beginStr);
    }

    private String countAndSayDg(int nIndex, int n, String str) {
        if(nIndex >= n) {
            return str;
        }
        int index = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 != str.length() && str.charAt(i) == str.charAt(i + 1)) {
                index++;
            } else {
                builder.append(index).append(str.charAt(i));
                index = 1;
            }
        }
        return countAndSayDg(++nIndex, n, builder.toString());
    }

    public static void main(String[] args) {
        CountAndSayStr countAndSayStr = new CountAndSayStr();
        System.out.println(countAndSayStr.countAndSay(5));
    }



}
