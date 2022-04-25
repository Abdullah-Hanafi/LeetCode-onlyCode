package StockTrading.No714;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/27 22:59
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }

        //手中持有股票时最大的收益
        int buy = -prices[0];
        //手中不持有股票时最大的收益
        int sell = 0;

        for (int i = 1; i < days; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}