package TwoDimensional.No64_MinimumPathSum;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/4 10:34
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //dp���飺��������i��ʱ��dp[j]��ʾ��[0,0]��[i,j]����̾����
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    //ֻ������
                    //dp[j]�����£�dp[j-1]������[0,0]��[i,j-1]����̾���
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    //ֻ������
                    //dp�����£�ԭdp[j]����Ϊ[0��0]��[i-1,j]����̾���
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    //���л�������
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
