package StockTrading.No121;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/25 22:03
 * 121 122 714һ��ϵ��
 * 123 188 һ��ϵ��
 * 309��״̬������һ��ϵ��
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        //���г��й�Ʊʱ����������
        int buy = -prices[0];
        //����û�й�Ʊʱ����������
        int sell = 0;

        for (int i = 1; i < days; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}