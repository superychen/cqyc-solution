# -*- coding: utf-8 -*-
# @FileName: 128_longestConsecutive.py
# @Author: hwk
# @Time: 2024/1/5 15:54
"""

128. 最长连续序列
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
"""

"""
【动态规划】

首先，定义一个哈希表（用于判断某个数是否存在哈希表中）

然后遍历数组

如果当前数num存在哈希表，那么跳过

如果当前数num不存在哈希表中，那么查找num-1和num+1这两个数是不是在哈希表中

比如 num是5

1234 678都在哈希表中

遍历数组的时候，遇到1234678都会掠过

此时哈希表中，1的位置和4存的值都是4（证明1或者4所在的连续长度是4）

同理 6和8存的值都是3

那么此时5进来之后，看看4和6在不在哈希表内，如果在的话，一定是端点，一定能获取到值

所以5进来之后，发现左边有4个连续的，右边有3个连续的，加上自己一个，那么组成一个大连续的

4+1+3 = 8

所以要更新当前最长连续串的端点，也就是1的位置（5-4），8的位置（5+3），更新长度为8

只需要端点存值就行，因为端点中的值在遍历的时候如果在哈希表中就会略过

如果这个时候9又进来，那么它获取到8的位置有8，10的位置有0

更新连续子串长度（8+1+0）

所以更新左端点1（9-8）的值为9，右端点9（9+0）的值为9
"""


def demo(nums: list) -> int:
    """
    用哈希表存储每个端点值对应连续区间的长度
    若数已在哈希表中：跳过不做处理
    若是新数加入：
        取出其左右相邻数已有的连续区间长度 left 和 right
        计算当前数的区间长度为：cur_length = left + right + 1
        根据 cur_length 更新最大长度 max_length 的值
        更新区间两端点的长度值

    :param nums:
    :return:
    """
    hashtable = dict()
    max_len = 0
    for num in nums:
        if num not in hashtable:
            left = hashtable.get(num - 1, 0)
            right = hashtable.get(num + 1, 0)
            cur_len = 1 + left + right
            hashtable[num] = cur_len
            hashtable[num - left] = cur_len
            hashtable[num + right] = cur_len
            max_len = max(max_len, cur_len)
    return max_len


def demo1(nums: list) -> int:
    hashtable = dict()
    max_len = 0
    for num in nums:
        if num not in hashtable:
            left = hashtable.get(num - 1, 0)
            right = hashtable.get(num + 1, 0)
            cur_len = left + right + 1
            max_len = max(cur_len, max_len)
            hashtable[num] = cur_len
            hashtable[num - left] = cur_len
            hashtable[num + right] = cur_len
    print(max_len)
    return max_len


def demo2(nums: list) -> int:
    hashtable = dict()
    max_len = 0
    for num in nums:
        if num not in hashtable:
            left = hashtable.get(num - 1, 0)
            right = hashtable.get(num + 1, 0)
            cur_len = left + right + 1
            max_len = max(max_len, cur_len)
            hashtable[num] = cur_len
            hashtable[num - left] = cur_len
            hashtable[num + right] = cur_len
    print(max_len)
    return max_len


def demo3(nums: list) -> int:
    hashtable = dict()
    max_len = 0
    for num in nums:
        if num not in hashtable:
            left = hashtable.get(num - 1, 0)
            right = hashtable.get(num + 1, 0)
            cur_len = left + right + 1
            max_len = max(max_len, cur_len)
            hashtable[num] = cur_len
            hashtable[num - left] = cur_len
            hashtable[num + right] = cur_len
    print(max_len)
    return max_len


demo3([100, 4, 200, 1, 3, 2, 0])
