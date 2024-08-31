package com.cqyc.solution.other;

public class MyAtoi {


    public int myAtoi(String s) {
        //去掉所有空格
        s = s.trim();
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >=48 && chars[i] <= 57) {
                str.append(chars[i]);
            } else if(i != 0) {
                break;
            }
        }
        boolean flag = true;
        String res = str.toString();
        if("".equals(res)) {
            return 0;
        }
        if (chars[0] == '-' || chars[0] == '+') {
            flag = (chars[0] != '-');
        } else if(chars[0] <48 || chars[0] > 57) {
            return 0;
        }
        try {
             return flag ? Integer.parseInt(res) : -Integer.parseInt(res) ;
        } catch (Exception e) {
            return flag ? Integer.MAX_VALUE : -Integer.MAX_VALUE;
        }
    }

    public int myAtoi2(String str) {
        str = str.trim();//去掉前后的空格
        //如果为空，直接返回0
        if (str.length() == 0)
            return 0;
        int index = 0;//遍历字符串中字符的位置
        int res = 0;//最终结果
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = str.length();
        //判断符号
        if (str.charAt(index) == '-' || str.charAt(index) == '+')
            sign = str.charAt(index++) == '+' ? 1 : -1;
        for (; index < length; ++index) {
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9)
                break;
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                res = res * 10 + digit;
        }
        return sign * res;
    }


    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        String str = "   +0 123";
        System.out.println(myAtoi.myAtoi(str));
    }


}
