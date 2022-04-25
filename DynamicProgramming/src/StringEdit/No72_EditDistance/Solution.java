package StringEdit.No72_EditDistance;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/25 15:49
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        //dp[i][0]=i,即word2为空，word1不为空，此时需要增加i个字符才能和word1相同
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        //同上
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //字符相同时
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //字符串不想同时，要么修改，要么删除，要么增加
                    //修改word1或者修改word2，均为dp[i-1][j-1]+1
                    //删除word1，或者添加word2均为dp[i-1][j]+1
                    //删除word2，或者添加word1均为dp[i][j-1]+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];

    }
}
