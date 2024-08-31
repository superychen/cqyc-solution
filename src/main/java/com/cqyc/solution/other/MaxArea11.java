package com.cqyc.solution.other;

/**
 * @Description: 盛最多水的容器
 * @author: cqyc
 * @date 2022/1/7
 */
public class MaxArea11 {

    /**
     * 暴力破解法，两层for循环 O(n^2)
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     *O(N), 左右边界i，j。 向中间收敛， 左右夹通
     */
    public int maxAreaMid(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea11 test = new MaxArea11();
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int i = test.maxAreaMid(nums);
        System.out.println("max = " + i);
    }

}
