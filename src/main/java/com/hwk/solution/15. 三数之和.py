# -*- coding: utf-8 -*-
# @FileName: 15. 三数之和.py
# @Author: hwk
# @Time: 2024/1/15 9:42
"""
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。





示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。x`
"""
"""
特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
对数组进行排序。
遍历排序后数组：
若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
对于重复元素：跳过，避免出现重复解
令左指针 L=i+1，右指针 R=n−1，当 L<R 时，执行循环：
当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
若和大于 0，说明 nums[R] 太大，R 左移
若和小于 0，说明 nums[L] 太小，L 右移
"""


def demo(nums: list) -> list:
    n = len(nums)
    res = []
    if not nums or n < 3:
        return []
    nums.sort()
    for i in range(n):
        if nums[i] > 0:
            return res
        if i > 0 and nums[i] == nums[i - 1]:  # 有重复值，进行下次循环
            continue
        L = i + 1
        R = n - 1
        while L < R:
            if nums[i] + nums[L] + nums[R] == 0:
                res.append([nums[i], nums[L], nums[R]])
                while L < R and nums[L] == nums[L + 1]:  # 左边有重复值，L右移，不能用if, 要一直判断到没有重复值
                    L += 1
                while L < R and nums[R] == nums[R - 1]:
                    R -= 1
                L += 1
                R -= 1
            elif nums[i] + nums[L] + nums[R] > 0:  # 若和大于 0，说明 nums[R] 太大，R 左移
                R -= 1
            else:  # 若和小于 0，说明 nums[L] 太小，L 右移
                L += 1
    return res


def demo0919(nums: list):
    n = len(nums)
    res = []
    if not nums or n < 3:
        return []
    nums.sort()
    for i in range(n):
        if nums[i] > 0:
            return res
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        L, R = i + 1, n - 1
        while L < R:
            if nums[i] + nums[L] + nums[R] == 0:
                res.append([nums[i], nums[L], nums[R]])
                while L < R and nums[L] == nums[L + 1]:
                    L += 1
                while L < R and nums[R] == nums[R - 1]:
                    R -= 1
                L += 1
                R -= 1
            elif nums[i] + nums[L] + nums[R] > 0:
                R -= 1
            else:
                L += 1
    return res


print(demo([-1, 0, 1, 2, -1, -4]))
