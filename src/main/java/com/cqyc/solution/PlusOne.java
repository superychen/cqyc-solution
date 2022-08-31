package com.cqyc.solution;

/**
 * 加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                //设置为0
                digits[i] = 0;
            }
        }
        //最终情况，全是9的情况，开一个新数组，前面+1，比如999
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0};
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(input);
    }

}
