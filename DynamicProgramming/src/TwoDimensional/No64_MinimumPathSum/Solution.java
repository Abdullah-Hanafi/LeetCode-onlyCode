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

        //dp数组：遍历到第i行时，dp[j]表示从[0,0]到[i,j]的最短距离和
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    //只能右行
                    //dp[j]待更新，dp[j-1]正好是[0,0]到[i,j-1]的最短距离
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    //只能下行
                    //dp待更新，原dp[j]正好为[0，0]到[i-1,j]的最短距离
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    //右行或者下行
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
