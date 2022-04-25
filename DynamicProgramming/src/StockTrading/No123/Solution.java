package StockTrading.No123;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/27 17:19
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }

        //buy[1]:买1次的最大收益
        //buy[2]:买2次的最大收益
        int[] buy = new int[3];
        buy[0] = Integer.MIN_VALUE;
        buy[1] = Integer.MIN_VALUE;
        buy[2] = Integer.MIN_VALUE;

        //sell[1]:卖1次的最大收益
        //sell[2]:卖2次的最大收益
        int[] sell = new int[3];

        for (int i = 0; i < days; i++) {
            for (int j = 1; j <= 2; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[2];
    }
}
