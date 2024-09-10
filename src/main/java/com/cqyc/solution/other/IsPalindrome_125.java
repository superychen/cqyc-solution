package com.cqyc.solution.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断是否为回文字符串
 */
public class IsPalindrome_125 {

    public boolean isPalindrome(String s) {
        //全部转小写
        s = s.toLowerCase();
        String reverseStr = new StringBuilder(s).reverse().toString();
        char[] reverseChars = reverseStr.toCharArray();
        char[] chars = s.toCharArray();

        List<Character> reverseList = insertList(reverseChars);
        List<Character> characters = insertList(chars);

        for (int i = 0; i < reverseList.size(); i++) {
            if(reverseList.get(i).compareTo(characters.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    private List<Character> insertList(char[] chars) {
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            if(aChar >= 48 && aChar <= 57) {
                list.add(aChar);
            } else {
                int key = aChar - 'a';
                if(key >= 0 && key < 26) {
                    list.add(aChar);
                }
            }
        }
        return list;
    }


    public boolean isPalindromeHelper(String s, int left, int right) {
        if(left > right) {
            return true;
        }
        while(left < right && Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        while(left < right && Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)) && isPalindromeHelper(s, ++left, --right);
    }

        public static void main(String[] args) {
        IsPalindrome_125 isPalindrome = new IsPalindrome_125();
        String testStr = "A man, a plan, a canal: Panama";
        String testStr1 = "race a car";
        String testStr02 = "0P";
        String testStr03 = "Marge, let's \"[went].\" I await {news} telegram.";
        System.out.println(isPalindrome.isPalindrome(testStr03));
    }

}
