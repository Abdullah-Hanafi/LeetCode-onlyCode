package OneDimensional.No70_ClimbingStairs;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/29 9:52
 */
public class Solution {
    public int climbStairs(int n) {
        //±ﬂΩÁ¥¶¿Ì
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int climbStairs1(int n) {
        if (n <= 2) return n;
        int pre1 = 2;
        int pre2 = 1;
        int cur = 0;

        for (int i = 3; i <= n; i++) {
            cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
