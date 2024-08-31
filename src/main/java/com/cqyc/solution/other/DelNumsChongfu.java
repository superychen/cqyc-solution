package com.cqyc.solution.other;

public class DelNumsChongfu {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int index = 0;
        if(nums.length == 1) {
            return 1;
        }
        int res = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            int num = nums[i + 1];
            if(nums[index] != num) {
                index = i + 1;
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        DelNumsChongfu delNumsChongfu = new DelNumsChongfu();
        int[] target = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(delNumsChongfu.removeDuplicates(target));
    }

}
