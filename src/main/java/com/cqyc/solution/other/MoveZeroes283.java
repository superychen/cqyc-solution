package com.cqyc.solution.other;

/**
 * @Description:
 * @author: cqyc
 * @date 2022/1/6
 */
public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i];
            if(res != 0) {
                nums[i] = nums[j];
                nums[j] = res;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes283.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
