/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/
public class _309_BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;;
        int lastProfit = 0;
        boolean isLastPeak = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                lastProfit = prices[i] - prices[i - 1];
                profit += lastProfit;
                isLastPeak = true;
            } else if (i < prices.length - 1 && isLastPeak && prices[i] < prices[i - 1] && prices[i] > prices[i + 1]) {
                int p = prices[i + 1] - prices[i];
                if (p > lastProfit) {
                    profit = profit - lastProfit + p;
                    i++;
                }
            } else {
                isLastPeak = false;
            }
        }
        return profit;
    }
}