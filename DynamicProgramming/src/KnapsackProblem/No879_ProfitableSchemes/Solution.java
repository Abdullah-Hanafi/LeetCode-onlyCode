package KnapsackProblem.No879_ProfitableSchemes;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/21 9:58
 */
public class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int length = group.length;
        int MOD = (int) 1e9 + 7;
        // dp[i][j][k]��ʾ��ǰi��������ѡ����j��Ա�����������㹤����������Ϊk������µ�ӯ���ƻ�������Ŀ��
        int[][][] dp = new int[length + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int members = group[i - 1];
            int earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < members) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                    }
                }
            }
        }

        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[length][j][minProfit]) % MOD;
        }
        return sum;
    }


    //���о���ѹ��
    public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
        int length = group.length;
        int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= length; i++) {
            int members = group[i - 1];
            int earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }

        return dp[n][minProfit];
    }
}
