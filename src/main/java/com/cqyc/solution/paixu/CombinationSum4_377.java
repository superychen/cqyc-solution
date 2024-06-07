package com.cqyc.solution.paixu;

/**
 * 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 */
public class CombinationSum4_377 {

    //相当于爬楼梯，只不过多了议程i >= num的判断，因为爬的楼梯不可能小于给出的楼梯数量啥
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //动态规划的边界是 dp[0]=1。只有当不选取任何元素时，元素之和才为 0，因此只有 1 种方案
        dp[0] = 1;
        //当 1 ≤ i ≤ target时，如果存在一种排列，其中的元素之和等于 i，则该排列的最后一个元素一定是数组 nums 中的一个元素
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
