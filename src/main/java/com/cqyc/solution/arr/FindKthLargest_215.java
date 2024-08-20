package com.cqyc.solution.arr;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 快排
 * @author: CQYC
 * @date: 2024-08-20-8:46
 */
public class FindKthLargest_215 {

    /**
     * 最简单
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        if(k == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 快速排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        //定义基准数（可以为随机下标的数，这里定义了最左边的为基准数）
        int l = 0;
        int r = n - 1;
        while(true) {
            //交换后的基准值下标，左边是比他大的，右边比他小
            int LIndex = partition(nums, l, r);
            if(LIndex == k - 1) {
                return nums[LIndex];
            } else if (LIndex > k - 1) {
                r = LIndex - 1;
            } else {
                l = LIndex + 1;
            }

        }
    }

    private int partition(int[] nums, int l, int r) {
        //把基准数取出来
        int pivot = nums[l];
        int begin = l;
        while(l < r) {
            while(l < r && nums[r] <= pivot) {
                r--;
            }
            while(l < r && nums[l] >= pivot) {
                l++;
            }
            //swap交换
            if(l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        //然后再把最开始的基准值进行swap交换
        int tmp = nums[begin];
        nums[begin] = nums[l];
        nums[l] = tmp;
        return l;
    }



}
