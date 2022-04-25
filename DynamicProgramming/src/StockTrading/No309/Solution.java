package StockTrading.No309;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/27 17:26
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        //dp[i][0]:��i��������й�Ʊ
        //dp[i][1]:��i�����û�й�Ʊ�����ڶ����ڣ���i+1�첻����
        //dp[i][2]:��i�����û�й�Ʊ���Ҳ��ڶ����ڣ���i+1�������
        int[][] dp = new int[days][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[days - 1][1], dp[days - 1][2]);
    }
}
