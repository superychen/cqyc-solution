package com.cqyc.solution;

import java.util.*;

/**
 * 两个数组的交集
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resInt = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int i1 = 0; i1 < nums2.length; i1++) {
                if(nums1[i] == nums2[i1]) {
                   if(set.contains(i1) || set1.contains(i)) {
                       continue;
                   }
                   set.add(i1);
                   set1.add(i);
                   resInt.add(nums1[i]);
                }
            }
        }
        int[] res = new int[resInt.size()];
        Integer[] integers = resInt.toArray(new Integer[resInt.size()]);
        for (int i = 0; i < integers.length; i++) {
            res[i] = integers[i];
        }
        return res;
    }

    /**
     * 先对数组进行排序
     * 先对两个数组进行排序，然后使用两个指针，分别指向两个数组开始的位置。
     *
     * 如果两个指针指向的值相同，说明这个值是他们的交集，就把这个值加入到集合list中，然后两个指针在分别往后移一步。
     * 如果两个指针指向的值不同，那么指向的值相对小的往后移一步，相对大的先不动，然后再比较
     */
    public int[] intersectTwo(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //设置两个不同的指针
        int index1 = 0;
        int index2 = 0;
        List<Integer> resInt = new ArrayList<>();
        while(index1 <= nums1.length - 1  && index2 <= nums2.length - 1) {
            if(nums1[index1] == nums2[index2]) {
                resInt.add(nums1[index1]);
                index1++;
                index2++;
            } else {
                if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        int[] res = new int[resInt.size()];
        Integer[] integers = resInt.toArray(new Integer[resInt.size()]);
        for (int i = 0; i < integers.length; i++) {
            res[i] = integers[i];
        }
        return res;
    }


    public int[] intersect_03(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //双指针，谁小就往下移动
        int i = 0;
        int j = 0;
        int index = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        if(index == res.length) {
            return res;
        }
        int[] newRes = new int[index];
        for (int k = 0; k < index; k++) {
            newRes[k] = res[k];
        }
        return newRes;
    }

    public static void main(String[] args) {
        int[] i = new int[]{4,9, 5};
        int[] j = new int[]{9,4, 9,8,4, 5};
        int[] i2 = new int[]{1,2,2,1};
        int[] j2 = new int[]{2, 2};
        Intersect intersect = new Intersect();
        int[] intersect1 = intersect.intersect_03(i, j);
        for (int i1 : intersect1) {
            System.out.println("i1 = " + i1);
        }

    }


}
