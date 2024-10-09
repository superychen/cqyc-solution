# -*- coding: utf-8 -*-
# @FileName: 560_subarraySum.py
# @Author: hwk
# @Time: 2024/9/27 14:20
"""
560. 和为 K 的子数组
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。



示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2

"""


def subarray_sum(nums, k):
    count = 0
    for start in range(len(nums)):  # 遍历start，end从start往左遍历然后求和
        sum = 0
        for end in range(start, -1, -1): # end需要遍历到下标0的位置，所以是range(*, -1, *)
            sum += nums[end]
            if sum == k:
                count += 1
    return count

def subarray_sum0929(nums: list, k: int) -> int:
    count = 0
    for start in range(len(nums)):
        sum = 0
        for end in range(start, -1, -1):
            sum += nums[end]
            if sum == k:
                count += 1
    return count


print(subarray_sum([1, 3, 5, 4, 1, 2], 9))
