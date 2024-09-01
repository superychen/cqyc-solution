package com.cqyc.solution.arr;

import java.util.*;

/**
 *
 *
 * 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * @Description:
 * @author: cqyc
 * @date 2022/1/10
 */
public class 三数之和_15 {

    //三重for循环
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resList = new LinkedHashSet<>();
        if(nums.length <= 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                List<Integer> resNums = new ArrayList<>();
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        resNums.add(nums[i]);
                        resNums.add(nums[j]);
                        resNums.add(nums[k]);
                    }
                }
                if (resNums.size() != 0) {
                    resList.add(resNums);
                }
            }
        }
        return new ArrayList<>(resList);
    }

    /**
     * 双指针
     * 双指针法铺垫： 先将给定 nums 排序，复杂度为 O(NlogN)O(NlogN)。
     * 双指针法思路： 固定 33 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，通过双指针交替向中间移动
     * ，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
     * 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 33 个数字都大于 00 ，在此固定指针 k 之后不可能再找到结果了。
     * 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
     * i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
     * 当s < 0时，i += 1并跳过所有重复的nums[i]；
     * 当s > 0时，j -= 1并跳过所有重复的nums[j]；
     * 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
     */
    public List<List<Integer>> threeSumDoublePointer(int[] nums) {
        //对数组进行排序,从小到大依次排序
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            //因为k在最左边，如果nums[k]>0, 一定不存在
            if(nums[k] > 0) {
                break;
            }
            //两结果相等，直接跳过，循环两次结果一样，上一次已经遍历所有结果，直接跳过本次循环
            if(k > 0 && (nums[k] == nums[k - 1])) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while(i < j) {
                //加判断情况
                int s = nums[k] + nums[i] + nums[j];
                if(s < 0) {
                    i++;
                } else if(s > 0) {
                    j--;
                } else {
                    //最后需要去重
                    resList.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    //去重,不能使用++i，具体区分i++和++i的区别
                    while(i < j && (nums[i] == nums[++i]));
                    while(i < j && (nums[j] == nums[--j])); //去重
                }
            }
        }
        return resList;
    }



    public static void main(String[] args) {
        三数之和_15 sum15 = new 三数之和_15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = sum15.threeSumDoublePointer(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("\n---");
        }
    }

}
