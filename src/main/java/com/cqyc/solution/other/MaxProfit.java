package com.cqyc.solution.other;



/**
 * 买卖股票的最佳时机 II
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};

        int[] prices2 = new int[]{1,2,3,4,5};
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(prices);
        System.out.println("i = " + i);

    }

    public int maxProfit(int[] prices) {
       if(prices == null || prices.length < 2) {
           return 0;
       }
       int resMax = 0;
       for (int i = 0; i < prices.length - 1; i++) {
           int price =  prices[i + 1] - prices[i];
           if(price > 0) {
               resMax += price;
           }
       }
       return resMax;
    }






}
