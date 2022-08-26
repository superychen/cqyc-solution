package com.cqyc.solution;

import java.util.Arrays;

public class SingleNumber {

    /**
     * 排序在比较
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 位运算
     */
    public int singleNumberTwo(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }


    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumberTwo(new int[]{4,1,1,2,4});
    }
}
