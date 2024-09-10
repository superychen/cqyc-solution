package com.cqyc.solution.other;

import java.util.Arrays;

/**
 * @author cqyc
 * @create 2022-09-22-11:20
 */
public class CountPrimes_204 {

    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isCountPrimes(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isCountPrimes(int count) {
        for (int i = 2; i * i <= count; i++) {
            if(count % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes_two(int n) {
        if(n < 2) {
            return 0;
        }
        int[] resNum = new int[n];
        Arrays.fill(resNum, 1);
        int ans = 0;

        for (int i = 2; i < n; i++) {
            if(resNum[i] == 1) {
                ans += 1;
                if((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        resNum[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
