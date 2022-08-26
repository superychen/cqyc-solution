package com.cqyc.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void main(String[] args) {
        int[] i = new int[]{4,9,5};
        int[] j = new int[]{9,4, 9,8,4};
        Intersect intersect = new Intersect();
        int[] intersect1 = intersect.intersect(i, j);
        for (int i1 : intersect1) {
            System.out.println("i1 = " + i1);
        }

    }


}
