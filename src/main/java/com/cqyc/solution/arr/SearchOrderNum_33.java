package com.cqyc.solution.arr;

/**
 * 搜索旋转排序数组（就是数组中查找某个数）
 *
 * @author cqyc
 * @create 2024-08-24-14:20
 */
public class SearchOrderNum_33 {

    /**
     * 二分查找，这里只是演示一下什么是二分查找，要看search方法才是这题解决方案
     */
    public int searchTwo(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else{
                if(nums[mid] < target && nums[nums.length - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        SearchOrderNum_33 test = new SearchOrderNum_33();
        int search = test.search(nums, 0);
        System.out.println("search = " + search);
    }

}
