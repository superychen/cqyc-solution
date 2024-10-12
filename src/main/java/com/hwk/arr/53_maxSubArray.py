# -*- coding: utf-8 -*-
# @FileName: 53_maxSubArray.py
# @Author: hwk
# @Time: 2024/9/29 17:42

"""
53. 最大子数组和

给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组
是数组中的一个连续部分。



示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23
"""


def maxSubArray(nums: list) -> int:
    """
    走完这一生 如果我和你在一起会变得更好，那我们就在一起，否则我就丢下你。 我回顾我最光辉的时刻就是和不同人在一起，变得更好的最长连续时刻
    :param nums:
    :return:
    """
    pre = 0
    maxAns = nums[0]
    for x in nums:
        pre = max(pre + x, x)
        maxAns = max(maxAns, pre)
    return maxAns

def maxSubArray1011(nums: list) -> list:
    pre = 0
    ans = nums[0]
    for n in nums:
        pre = max(pre + n, n)
        ans = max(ans, pre)
    return ans

def maxSubArray1009(nums: list) -> int:
    pre = 0
    ans = nums[0]
    for n in nums:
        pre = max(pre + n, n)
        ans = max(ans, pre)
    return ans


def maxSubArray1008(nums: list) -> int:
    pre = 0
    ans = nums[0]
    for n in nums:
        pre = max(pre + n, n)
        ans = max(ans, pre)
    return ans


print(maxSubArray([-1, 1, 2, -2, 3, -3, 5]))
