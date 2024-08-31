package com.cqyc.solution.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoNumberSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer value = resMap.get(target - nums[i]);
            if(value != null) {
                index = i;
                break;
            }
            resMap.put(nums[i], i);
        }
        return new int[]{index, resMap.get(target - nums[index])};
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 4};
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        twoNumberSum.twoSum(ints, 6);
        double[][] class_score={{10.0,99,99,5},{100,98,97,2},{100,100,99.5,5},{99.5,99,98.5,5}};
        System.out.println(class_score.length);

        System.out.println(3 - '0' - 1);
        System.out.println(5 - '0' - 1);
    }

}
