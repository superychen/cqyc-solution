# -*- coding: utf-8 -*-
# @FileName: test.py
# @Author: hwk
# @Time: 2024/10/15 18:08
from collections import deque

list1 = [1, 3, 6]
queue = deque(list1)

print(queue)
queue.popleft()
print(queue)