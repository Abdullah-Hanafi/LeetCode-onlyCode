package StockTrading.No188;

import java.util.Arrays;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/27 17:18
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        if (k >= days - 1) {
            return maxProfitOfPrices(prices);
        }

        //buy[j]:��j�ε��������
        int[] buy = new int[k + 1];
        //sell[j]:��j�ε��������
        int[] sell = new int[k + 1];
        //��ʼ��
        for (int i = 0; i < k + 1; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < days; i++) {
            for (int j = 1; j < k + 1; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }

    //�����״���k>=days-1��ʱ��,��Ϊdays��ཻ��days-1��
    public int maxProfitOfPrices(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}