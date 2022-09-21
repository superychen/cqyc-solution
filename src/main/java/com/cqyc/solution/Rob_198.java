package com.cqyc.solution;

import java.util.Random;

/**
 * @author cqyc
 * @create 2022-09-21-11:24
 */
public class Rob_198 {

    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) {
            return 0;
        }
        int[] db = new int[length + 1];
        db[0] = 0;
        db[1] = nums[0];
        for (int i = 2; i <= length; i++) {
            int fx_1 = db[i - 1];
            int fx_2 = nums[i - 1] + db[i - 2];

            db[i] = Math.max(fx_1, fx_2);
        }
        return db[length];
    }

    public static void main(String[] args) {
        int[] ints = {2, 1, 1, 2};
        Rob_198 rob_198 = new Rob_198();
        System.out.println(rob_198.rob(ints));

        Random random = new Random();
        int i = random.nextInt(2);
        System.out.println("i = " + i);
    }
}
