package StockTrading.No121;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/25 22:03
 * 121 122 714一个系列
 * 123 188 一个系列
 * 309用状态机单独一个系列
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        //手中持有股票时，最大的收益
        int buy = -prices[0];
        //手中没有股票时，最大的收益
        int sell = 0;

        for (int i = 1; i < days; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}