package DivideType.No279_PerfectSquares;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/10 10:31
 */
public class Solution {
    public int numSquares(int n) {
        //dp[i]��ʾ����i��ƽ��������С����
        int[] dp = new int[n + 1];

        //���μ���dp[i]
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
