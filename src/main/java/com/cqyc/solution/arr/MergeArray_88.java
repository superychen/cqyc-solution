package com.cqyc.solution.arr;

/**
 * 合并两个有序数组
 *给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class MergeArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int l1 = 0;
        int l2 = 0;
        int tmpInt;
        while(l1 < m || l2 < n) {
            if(l1 == m) {
                tmpInt = nums2[l2++];
            } else if(l2 == n) {
                tmpInt = nums1[l1++];
            } else if(nums1[l1] < nums2[l2]) {
                tmpInt = nums1[l1++];
            } else {
                tmpInt = nums2[l2++];
            }
            res[l1 + l2 - 1] = tmpInt;
        }
        for (int i1 = 0; i1 < res.length; i1++) {
            nums1[i1] = res[i1];
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums1 = new int[]{};
//        int[] nums2 = new int[]{2,5,6};
        int[] nums2 = new int[]{1};
        MergeArray_88 test = new MergeArray_88();
        test.merge(nums1, 0, nums2, 1);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }

}
