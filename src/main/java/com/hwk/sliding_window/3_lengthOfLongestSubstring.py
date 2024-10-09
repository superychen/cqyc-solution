# -*- coding: utf-8 -*-
# @FileName: 3_lengthOfLongestSubstring.py
# @Author: hwk
# @Time: 2024/1/9 9:40
"""
3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
"""


def lengthOfLongestSubstring(s: str) -> int:
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]  # 遍历到相同的字符，就删掉该字符以及前面的内容，例如：pewacw,当循环到tp中存在的元素‘w’时,将tp的值pewac变为ac,再补上w,再记录最大长度
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def demo0919(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def demo0913(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def demo0829(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def test0828(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def demo0828(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len)

def demo0827(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len


def demo0825(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def demo0824(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len

def demo0823(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))


def demo0814(s):
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len


def demo(s: str) -> int:
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len


def demo1(s: str) -> int:
    tp = []
    max_len = 0
    for i in s:
        while i in tp:
            del tp[0]
        tp.append(i)
        max_len = max(max_len, len(tp))
    return max_len


print(demo0919("pewacw"))
