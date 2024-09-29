# -*- coding: utf-8 -*-
# @FileName: 1. 两数之和.py
# @Author: hwk
# @Time: 2024/1/8 9:59
"""
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]
"""


def twoSum(nums: list, target: int) -> list:
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        # 放入hashtable需要在if判断之后,否则会导致返回下标重复，例如：demo3([2, 7, 11, 15], 4), 2落库后，再判断4-2是否存在，直接返回下标[0,0]
        hashtable[nums[i]] = i
    return []

def demo0919(nums: list, target: int):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []

def twoSum0913(nums: list, target: int):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo0828(nums: list, target: int):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def twoSum0825(nums: list, target: int):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def twoSum0824(nums: list, target: int):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def twoSum0826(nums: list, target: int) -> list:
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo0816(nums: list, target: int):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo0814(nums, target):
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo(nums: list, target: int) -> list:
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo1(nums: list, target: int) -> list:
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo2(nums: list, target: int) -> list:
    hashtable = dict()
    for i, num in enumerate(nums):
        if target - num in hashtable:
            return [i, hashtable[target - num]]
        hashtable[nums[i]] = i
    return []


def demo3(nums: list, target: int) -> list:
    hashtable = dict()
    for i, num in enumerate(nums):
        hashtable[nums[i]] = i
        if target - num in hashtable:
            return [i, hashtable[target - num]]
    return []


print(demo0919([2, 7, 11, 15], 17))
