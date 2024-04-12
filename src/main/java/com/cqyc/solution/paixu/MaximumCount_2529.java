package com.cqyc.solution.paixu;

import java.util.Arrays;
import java.util.List;

/**
 * 正整数和负整数的最大计数
 * 二分查找
 * @author: CQYC
 * @date: 2024-04-09-9:32
 */
public class MaximumCount_2529 {

    public int maximumCount1(int[] nums) {
        int pos1 = lowerBound(nums, 0);
        int pos2 = lowerBound(nums, 1);
        return Math.max(pos1, nums.length - pos2);
    }

    public int lowerBound(int[] nums, int val) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }


    public int maximumCount(int[] nums) {
        if(nums.length == 1 && nums[0] == 0) {
            return 0;
        }
        if(nums.length <= 1) {
            return nums.length;
        }
        int negative = 0;
        int positive = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            if(nums.length % 2 == 0 && (left - right == 1)) {
                break;
            }
            if(nums[left] < 0) {
                negative++;
            }
            if(nums[right] < 0) {
                negative++;
            }
            if(nums[left] > 0) {
                positive++;
            }
            if(nums[right] > 0) {
                positive++;
            }
            left++;
            right--;
            if(left == right) {
                if(nums[left] < 0) {
                    negative++;
                }
                if(nums[left] > 0) {
                    positive++;
                }
            }
        }
        return Math.max(negative, positive);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-2,-1,-1,1,2,3};
//        int[] nums = new int[]{5,20,66,1314};
        int[] nums = new int[]{-3,-2,-1,0,0,1,2};
//        int[] nums = new int[]{-2,-1,-1,1,2,3};
//        int[] nums = new int[]{-1,2,2};
        MaximumCount_2529 test = new MaximumCount_2529();
        System.out.println("test = " + test.maximumCount1(nums));

    }

}
