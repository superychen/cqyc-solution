package com.cqyc.solution;

/**
 * 旋转数组
 */
public class RotateNums {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        //反转全部
        reverse(nums, 0, length - 1);
        //反转前面
        reverse(nums, 0, k - 1);
        //反转后面
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
