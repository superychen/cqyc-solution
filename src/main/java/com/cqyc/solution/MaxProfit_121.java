package com.cqyc.solution;

/**
 * 买卖股票的最佳时机
 * @author cqyc
 * @create 2022-09-20-09:24
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }

}
