# -*- coding: utf-8 -*-
# @FileName: 56_merge.py
# @Author: hwk
# @Time: 2024/10/9 17:34
"""
56. 合并区间

以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

"""


def merge(intervals: list) -> list:
    intervals.sort(key=lambda x: x[0])
    merged = []
    for interval in intervals:
        if not merged or interval[0] > merged[-1][1]:  # 如果当前数组左端点大于merged最后区间的右端点（意思就是区间不重合），直接append
            merged.append(interval)
        else:  # 如果区间有重合，更新merged右端点为较大值
            merged[-1][1] = max(merged[-1][1], interval[1])
    return merged


def merge1012(intervals: list) -> list:
    intervals.sort(key=lambda x: x[0])
    merged = []
    for interval in intervals:
        if not merged or interval[0] > merged[-1][1]:
            merged.append(interval)
        else:
            merged[-1][1] = max(merged[-1][1], interval[1])
    return merged


def merge1011(intervals: list) -> list:
    intervals.sort(key=lambda x: x[0])
    merged = []
    for interval in intervals:
        if not merged or interval[0] > merged[-1][1]:
            merged.append(interval)
        else:
            merged[-1][1] = max(merged[-1][1], interval[1])
    return merged


print(merge([[1, 3], [3, 6], [2, 5], [8, 10], [15, 18]]))
