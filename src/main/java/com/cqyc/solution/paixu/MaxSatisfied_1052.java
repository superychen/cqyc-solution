package com.cqyc.solution.paixu;

import java.util.Arrays;

/**
 * 爱生气的书店老板
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，
 * 其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 *
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 *
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 */
public class MaxSatisfied_1052 {

    /**
     * 可行，但是会超出时间限制，需要使用滑动窗口
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if(grumpy.length <= minutes) {
            return computeMax(customers);
        }
        int max = 0;
        for (int i = 0; i <= grumpy.length - minutes; i++) {
            int[] temp = Arrays.copyOf(grumpy, grumpy.length);
            int[] tempCustomer = Arrays.copyOf(customers, customers.length);;
            if(minutes > 0) {
                for (int j = i; j < i + minutes; j++) {
                    temp[j] = 0;
                }
            }
            for (int i1 = 0; i1 < temp.length; i1++) {
                if(temp[i1] == 1) {
                    tempCustomer[i1] = 0;
                }
            }
            max = Math.max(max, computeMax(tempCustomer));
        }
        return max;
    }

    private int computeMax(int[] resArr) {
        int max = 0;
        for (int i : resArr) {
            max += i;
        }
        return max;
    }

    /**
     * 使用滑动窗口进行处理
     */
    public int maxSatisfied_two(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < minutes; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = minutes; i < n; i++) {
            increase = increase - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }



    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int minutes = 3;
        MaxSatisfied_1052 test = new MaxSatisfied_1052();
        int i = test.maxSatisfied(customers, grumpy, minutes);
        System.out.println("i = " + i);
    }

}
