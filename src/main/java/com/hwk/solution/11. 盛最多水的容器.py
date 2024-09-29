# -*- coding: utf-8 -*-
# @FileName: 11. 盛最多水的容器.py
# @Author: hwk
# @Time: 2024/1/10 10:34
"""
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。

示例 1：
输入：[1,8,6,2,5,4,8,3,7]
输出：49

示例 2：
输入：height = [1,1]
输出：1
"""
"""
假设当前左指针和右指针指向的数分别为 xxx 和 yyy，不失一般性，我们假设 x≤y。同时，两个指针之间的距离为 t。那么，它们组成的容器的容量为：
min(x,y)*t = x*t 
我们可以断定，如果我们保持左指针的位置不变，那么无论右指针在哪里，这个容器的容量都不会超过 x∗t了。
注意这里右指针只能向左移动，因为 我们考虑的是第一步，也就是 指针还指向数组的左右边界的时候。
我们任意向左移动右指针，指向的数为 y1,两个指针之间的距离为t1,那么显然有 t1<t，并且
如果 y1<=y 则 min(x,y1)<=min(x,y)
如果 y1>y 则 min(x,y1)=min(x,y)=x
所以： min(x,y1)<=min(x,y)   //坐标系X轴（正整数）可加深理解

!!!所以： min(x,y1)*t1 < min(x,y)*t

即无论我们怎么移动右指针，得到的容器的容量都小于移动前容器的容量。也就是说，这个左指针对应的数不会作为容器的边界了，
那么我们就可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针于原先的右指针之间的左右位置，才可能会作为容器的边界。
这样以来，我们将问题的规模减小了 111，被我们丢弃的那个位置就相当于消失了。此时的左右指针，就指向了一个新的、规模减少了的问题的数组的左右边界，
因此，我们可以继续像之前 考虑第一步 那样考虑这个问题：
求出当前双指针对应的容器的容量；
对应数字较小的那个指针以后不可能作为容器的边界了，将其丢弃，并移动对应的指针。
"""


def maxArea(height: list) -> int:
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        area = min(height[l], height[r]) * (r - l)  # 计算面积
        ans = max(area, ans)
        if height[l] <= height[r]:  # 左边小，就左边界向右移
            l += 1
        else:
            r -= 1
    return ans


def demo0913(height: list):
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
        area = min(height[l], height[r]) * (r - l)
        ans = max(area, ans)
    return ans


def demo0829(height):
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        area = min(height[l], height[r]) * (r - l)
        ans = max(area, ans)
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
    return ans


def demo0828(height: list):
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        area = min(height[l], height[r]) * (r - l)
        ans = max(area, ans)
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
    return ans


def demo(height) -> int:
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        area = min(height[l], height[r]) * (r - l)
        ans = max(area, ans)
        if height[l] <= height[r]:  # 无论我们怎么移动右指针，得到的容器的容量都小于移动前容器的容量
            l += 1
        else:
            r -= 1
    return ans


def demo3(height) -> int:
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        area = min(height[l], height[r] * (r - l))
        ans = max(area, ans)
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
    return ans


def demo2(height):
    l, r = 0, len(height) - 1
    ans = 0
    while l < r:
        area = min(height[l], height[r]) * (r - l)
        ans = max(ans, area)
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
    return ans


print(demo0913([1, 8, 6, 2, 5, 4, 8, 3, 7]))
