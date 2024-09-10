package com.cqyc.solution.other;

/**
 *
 * 连续子数组的最大和
 * @author cqyc
 * @create 2022-09-21-09:38
 */
public class MaxSubArray_42 {

    public int maxSubArray(int[] nums) {
        int fi = 0;
        int max = nums[0];
        for (int num : nums) {
            fi = Math.max(fi + num, num);
            max = Math.max(fi, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] param = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray_42 array42 = new MaxSubArray_42();
        System.out.println(array42.maxSubArray(param));
    }

}
