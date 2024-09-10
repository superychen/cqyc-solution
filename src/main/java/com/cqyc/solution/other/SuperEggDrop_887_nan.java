package com.cqyc.solution.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cqyc
 * @create 2022-10-17-10:25
 *
 *  鸡蛋掉落摔碎问题
 */
public class SuperEggDrop_887_nan {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if(!memo.containsKey(n * 100 + k)) {
            int ans;
            if(n == 0) {
                ans = 0;
            } else if(k == 1) { //如果鸡蛋还剩一个就直接等于多少个鸡蛋
                ans = n;
            } else { //二分法
                int lo = 1;
                int hi = n;
                while(lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(k - 1, x - 1); //鸡蛋掉落就摔碎的情况，摔碎后只能晓得k - 1到 x - 1
                    int t2 = dp(k, n - x); //鸡蛋掉落不摔碎的情况，不摔碎就能晓得是k

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }
                ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
            }
            memo.put(n * 100 + k, ans);
        }
        return memo.get(n * 100 + k);
    }

    public static void main(String[] args) {
        SuperEggDrop_887_nan test = new SuperEggDrop_887_nan();
        System.out.println(test.dp(2, 6));
    }




}
