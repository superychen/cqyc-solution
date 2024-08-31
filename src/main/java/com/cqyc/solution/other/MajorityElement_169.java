package com.cqyc.solution.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素169。这题主要靠分治算法。。。
 * @author cqyc
 * @create 2022-09-30-09:50
 */
public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if(count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count + 1);
            }
        }
        int max = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
            if(max == entry.getValue()) {
                res = entry.getKey();
            }
        }
        return res;
    }

    public int majorityElement_two(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                j++;
            } else {
                j = 1;
            }
            if(j > max) {
                res = nums[i];
                max = j;
            }

        }
        return res;
    }

    /**
     * 利用分治算法解决，将若干个问题换成小问题解决
     * @param nums
     * @return
     */
    public int majorityElement_three(int[] nums) {
        return majorityElement_three_fenzhi(nums, 0, nums.length - 1);
    }

    public int majorityElement_three_fenzhi(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }
        int mid = (end - start) / 2 + start;
        int left = majorityElement_three_fenzhi(nums, start, mid);
        int right = majorityElement_three_fenzhi(nums, mid + 1, end);

        if(left == right) {
            return left;
        }
        int leftCount = countMajorityElement(nums, left, start, end);
        int rightCount = countMajorityElement(nums, right, start, end);
        return leftCount > rightCount ? left : right;
    }

    public int countMajorityElement(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if(nums[i] == num) {
               count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        MajorityElement_169 majorityElement_169 = new MajorityElement_169();
        int i = majorityElement_169.majorityElement_three(new int[]{2,2,1,1,1,2,2});
        System.out.println("i = " + i);
    }

}
