# -*- coding: utf-8 -*-
# @FileName: 49. 字母异位词分组.py
# @Author: hwk
# @Time: 2024/1/8 10:24
"""
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]
"""


def demo0910(strs: list) -> list:
    table = dict()
    for s in strs:
        sor_s = ''.join(sorted(s))
        if sor_s not in table:
            table[sor_s] = [s]
        else:
            table[sor_s].append(s)
    return list(table.values())


print(demo0910(["eat", "tea", "tan", "ate", "nat", "bat"]))
