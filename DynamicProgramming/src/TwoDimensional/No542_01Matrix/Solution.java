package TwoDimensional.No542_01Matrix;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/5 14:08
 */
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //不用进行边界处理
        int m = mat.length;
        int n = mat[0].length;

        //dp[i,j]数组表示[i,j]到最近0的距离
        int[][] dp = new int[m][n];

        //初始化dp数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : 20000;
            }
        }

        //从左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }

                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }


        //从右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
