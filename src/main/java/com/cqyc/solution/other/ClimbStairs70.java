package com.cqyc.solution.other;

/**
 * @Description: 70 爬楼梯
 * @author: cqyc
 * @date 2022/1/7
 */
public class ClimbStairs70 {

    /**
     * 暴力破解法，会超时
     * 1：1
     * 2：2
     * 3：f(2) + f(1)
     * 4: (f3) + f(2)
     * n: f(n - 1) + f(n - 2)
     */
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        if(n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        int i = f3;
        while (i <= n) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            i++;
        }
        return f3;
    }



}
