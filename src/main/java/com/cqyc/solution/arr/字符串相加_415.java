package com.cqyc.solution.arr;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * @author: CQYC
 * @date: 2024-09-10-10:36
 */
public class 字符串相加_415 {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int left = num1.length() - 1;
        int right = num2.length() - 1;
        while(left >= 0 || right >= 0) {
            int n = left >= 0 ? num1.charAt(left) - '0' : 0;
            int r = right >= 0 ? num2.charAt(right) - '0' : 0;
            int temp = n + r + carry;
            carry = temp / 10;
            res.append(temp % 10);
            left--;
            right--;
        }
        if(carry == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "456";
        String str2 = "77";
        字符串相加_415 test = new 字符串相加_415();
        System.out.println(test.addStrings(str1, str2));
    }
}
