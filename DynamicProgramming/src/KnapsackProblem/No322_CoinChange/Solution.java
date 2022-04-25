package KnapsackProblem.No322_CoinChange;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/25 15:24
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        //dp[i][j]表示用前i种金币兑换j元的最少硬币个数
        int[][] dp = new int[length + 1][amount + 1];
        //初始化为最大值
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = amount + 1;
            }
        }
        //初始化d[i][0]=0
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][amount] == (amount + 1) ? -1 : dp[length][amount];
    }
}