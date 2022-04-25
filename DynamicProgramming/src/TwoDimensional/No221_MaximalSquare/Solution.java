package TwoDimensional.No221_MaximalSquare;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/5 15:17
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //dp[i][j]表示以[i,j]为右下角的最大的正方形的边长
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
