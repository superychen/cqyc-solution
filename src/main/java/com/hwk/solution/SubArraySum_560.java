package com.hwk.solution;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubArraySum_560 {

    // 遍历start，end从start往左遍历然后求和
    int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }

        }
        return count;
    }

    int demo0929(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        SubArraySum_560 SubArraySum_560 = new SubArraySum_560();
        System.out.println(SubArraySum_560.demo0929(new int[]{1, 2, 3, 2, 1, -1}, 5));
    }

}
