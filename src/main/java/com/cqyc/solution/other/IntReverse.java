package com.cqyc.solution.other;

/**
 * @author cqyc
 * @create 2022-09-03-14:08
 * 整数反转
 */
public class IntReverse {

    public int reverse(int x) {
        //定义一个负数的标志位
        boolean flag = true;
        if(x < 0) {
            x = Math.abs(x);
            flag = false;
        }
        String res = String.valueOf(x);
        int start = 0;
        int end = res.length() - 1;
        char[] chars = res.toCharArray();
        while(start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        String s = new String(chars);
        try {
            return flag ? Integer.parseInt(s) : -Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int target = -123;
        IntReverse reverse = new IntReverse();
        System.out.println(reverse.reverse(target));
    }

}
