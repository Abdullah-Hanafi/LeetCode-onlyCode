package KnapsackProblem.No474_OnesAndZeros;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/20 14:33
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        //dp[i][j][k]��ʾ��ǰi���ַ����У���j��0��k��1������ɶ��ٸ��ַ�����
        //��Ȼǰ0���ַ�������j��0��k��1�������0���ַ���
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int zeros = getZeros(strs[i - 1]);
            int ones = getOnes(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (zeros <= j && ones <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int getZeros(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    public int getOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int length = strs.length;
        //dp[i][j][k]��ʾ��ǰi���ַ����У���j��0��k��1������ɶ��ٸ��ַ�����
        //��Ȼǰ0���ַ�������j��0��k��1�������0���ַ���
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int zeros = getZeros(strs[i - 1]);
            int ones = getOnes(strs[i - 1]);
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
