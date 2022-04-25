package Exercise.No122_BestTimeToBuyAndSellStockII;

public class Solution {
    /**
     * 方法一：贪心
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 方法二：动态规划
     * 考虑到不能同时参与多笔交易，因此每天股票交易结束以后只有两种状态
     * 其一：交易结束后手里没有股票
     * 其二：交易结束后手里有一张股票
     * 定义状态数组dp[i][0],表示第i天交易完毕以后的收益
     * 定义状态数组dp[i][1]，表示第i天交易完毕以后的收益
     * dp[i][0]的状态转移方程：前一天手里没有持股票dp[i - 1 ][0],前一天持有股票今天卖出dp[i-1][0]+prices[i]
     * dp[i][1]的状态转移方程：前一天手里没有持股票今天购买dp[i - 1][0] -prices[i],前一天手里有股票dp[i - 1][1]
     *
     * @param prices
     * @return
     */

    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];

        //初始状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

}
