package com.dsa.leetcodePractice.arrayandstring;

/***
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class MaxProfit {

    /**
     * Two pointer solution.
     * Create pointers : buy at index 0 and sell at index 1.
     * increment sell in each step. Calculate profit. If profit>maxProfit then maxProfit = profit.
     * If sell price is less than buy price, then buy = sell. This will increase the profit
     * potential in future sell prices.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int mProfit = 0;
        int buy=0, sell=1;

        while(buy < prices.length-1 && sell < prices.length){
            int profit = prices[sell]-prices[buy];
            if(profit > mProfit)
                mProfit = profit;
            if(prices[buy]>prices[sell])
                buy = sell;
            sell++;
        }

        return mProfit;
    }
}
