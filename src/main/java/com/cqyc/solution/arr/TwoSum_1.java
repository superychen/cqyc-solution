package com.cqyc.solution.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoSum_1 {

    /**
     * 暴力枚举
     */
    public int[] twoSum01(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int findNum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(findNum == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hashMap
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}