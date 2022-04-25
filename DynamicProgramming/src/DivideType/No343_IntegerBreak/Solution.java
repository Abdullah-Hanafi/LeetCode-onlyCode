package DivideType.No343_IntegerBreak;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/28 11:02
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 2; j++) {
                dp[i] = Math.max(Math.max(dp[i], dp[i - j] * j), j * (i - j));
            }
        }
        return dp[n];
    }
}