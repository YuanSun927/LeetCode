/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/
public class _121_BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int low = prices[0];
        int high = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = 0;
            } else if (prices[i] > high) {
                high = prices[i];
                if (high - low > maxProfit) {
                    maxProfit = high - low;
                }
            }
        }
        return maxProfit;
    }
}