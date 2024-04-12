package com.cqyc.solution.paixu;

import java.util.Arrays;

/**
 * 修改后的最大二进制
 * @author: CQYC
 * @date: 2024-04-10-9:55
 */
public class BinaryString_1702 {

    /**
     * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
     *
     * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
     * 比方说， "00010" -> "10010"
     * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
     * 比方说， "00010" -> "00001"
     * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
     */
    public String maximumBinaryString(String binary) {
        int length = binary.length();
        char[] chars = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            //只处理当前字符为0的情况
            if(chars[i] == '0') {
                //如果当前为0，找到下一个字符为0的下标
                while(j <= i || (j < length && chars[j] == '1')) {
                    j++;
                }
                //将i、j下标为0的先全部替换为1，就是00转为10，所以i+1下标需要转换为0
                if(j < length) {
                    chars[i] = '1';
                    chars[j] = '1';
                    chars[i + 1] = '0';
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String str = "000110";
        BinaryString_1702 test = new BinaryString_1702();
        String s = test.maximumBinaryString(str);
        System.out.println("s = " + s);
    }

}
