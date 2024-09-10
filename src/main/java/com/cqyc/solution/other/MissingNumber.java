package com.cqyc.solution.other;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author cqyc
 * @create 2022-09-27-10:19
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        for (int k : nums) {
            stack.push(k);
        }
        for (int j = nums.length; j > 0; j--) {
            int pop = stack.pop();
            if(pop != j) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] res = new int[]{0};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(res));
    }

}
