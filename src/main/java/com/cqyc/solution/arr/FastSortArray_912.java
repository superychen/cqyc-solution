package com.cqyc.solution.arr;

/**
 * 数组排序
 * 给你一个整数数组 nums，请你将该数组升序排列
 * @author: CQYC
 * @date: 2024-08-22-8:42
 */
public class FastSortArray_912 {

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        //选取index位
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);

    }


    private int partition(int[] nums, int left, int right) {
        int begin = left;
        int pivot = nums[left];

        while(left < right) {
            while(left < right && nums[left + 1] <= pivot) {
                left++;
            }
            while(left < right && nums[right] >= pivot) {
                right--;
            }
            if(left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        //然后再把最开始的基准值进行swap交换
        int tmp = nums[begin];
        nums[begin] = nums[left];
        nums[left] = tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        FastSortArray_912 test = new FastSortArray_912();
        test.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
