package com.cqyc.solution.paixu;

import com.cqyc.solution.arr.FindChampion_2923;

import java.util.*;

/**
 * 从双倍数组中还原原数组
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 */
public class FindOriginalArray_2007 {

    /**
     * 首先把 changed\textit{changed}changed 排序，并且统计所有元素出现的频数。
     *
     * 然后我们从小到大依次遍历数组，如果对于一个元素，它的频数大于零，并且它的两倍数也还在数组中，我们则可以把它加入到答案中。
     *
     * 如果对于一个数找不到它两倍数，即两倍数的频数等于零，则说明无法找到原数组，返回空数组即可。
     *
     */
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : changed) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int a : changed) {
            if (count.get(a) == 0) {
                continue;
            }
            count.put(a, count.get(a) - 1);
            if (count.getOrDefault(a * 2, 0) == 0) {
                return new int[0];
            }
            count.put(a * 2, count.get(a * 2) - 1);
            res[i++] = a;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,2,6,8};

        FindOriginalArray_2007 test = new FindOriginalArray_2007();
        int[] originalArray = test.findOriginalArray(a);
        for (int i : originalArray) {
            System.out.print(i + ",");
        }
    }


}
