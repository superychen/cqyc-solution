# -*- coding: utf-8 -*-
# @FileName: 283. 移动零.py
# @Author: hwk
# @Time: 2024/1/8 11:07
"""
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。



示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]
"""


def demo(nums: list):
    if not nums:
        return 0
    j = 0  # j记录非0的个数
    for i in range(len(nums)):
        if nums[i]:
            nums[j] = nums[i]
            j += 1
    for i in range(j, len(nums)):
        nums[i] = 0
    return nums

def demo0919(nums: list):
    if not nums:
        return 0
    j = 0
    for i in range(len(nums)):
        if nums[i]:
            nums[j] = nums[i]
            j += 1
    for i in range(j, len(nums)):
        nums[i] = 0
    return nums


def demo1(nums: list):
    if not nums:
        return 0
    j = 0
    for i in range(len(nums)):
        if nums[i]:
            nums[j] = nums[i]
            j += 1
    for i in range(j, len(nums)):
        nums[i] = 0
    return nums


def demo2(nums: list):
    if not nums:
        return 0
    j = 0
    for i in range(len(nums)):
        if nums[i]:
            nums[j] = nums[i]
            j += 1
    for i in range(j, len(nums)):
        nums[i] = 0
    return nums


print(demo2([2, 0, 0, 4, 9, 0]))
