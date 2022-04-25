package KnapsackProblem.No494_TargetSum;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/20 16:13
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int temp = sum - target;
        if (temp < 0 || temp % 2 != 0) {
            return 0;
        }

        int length = nums.length;
        int neg = temp / 2;
        //dp[i][j]表示在前i个数中有多少种方案的和是j
        int[][] dp = new int[length + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (num <= j) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[length][neg];
    }

    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int temp = sum - target;
        if (temp < 0 || temp % 2 != 0) {
            return 0;
        }
        int neg = temp / 2;

        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}