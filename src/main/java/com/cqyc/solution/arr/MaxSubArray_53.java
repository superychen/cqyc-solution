package com.cqyc.solution.arr;

import java.util.HashMap;

/**
 * 53题：最大子数组和
 * @author: CQYC
 * @date: 2024-08-21-8:58
 */
public class MaxSubArray_53 {

    /**
     * 暴力，会超出时间限制
     * @param nums
     * @return
     */
    public int maxSubArray01(int[] nums) {
        if(nums.length <= 1) {
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ans = nums[i];
            res = Math.max(res, ans);
            for (int j = i + 1; j < nums.length; j++) {
                ans = ans + nums[j];
                res = Math.max(res, ans);
            }
        }
        return res;
    }

    /**
     * 动态规划，定义动态dp,
     * 若 dp[i−1]≤0 ，说明 dp[i−1] 对 dp[i] 产生负贡献，即 dp[i−1]+nums[i] 还不如 nums[i] 本身大。
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
           nums[i] = nums[i] + Math.max(nums[i - 1], 0);
           res = Math.max(res, nums[i]);
        }
        return res;
    }




}