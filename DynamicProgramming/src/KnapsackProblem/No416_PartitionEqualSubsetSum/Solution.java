package KnapsackProblem.No416_PartitionEqualSubsetSum;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/19 14:52
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[length + 1][target + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][target];
    }

    //矩阵压缩一下
    public boolean canPartition1(int[] nums) {
        int l = nums.length;
        //nums的长的为0或者1无法进行分割
        if (l < 2) {
            return false;
        }

        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int i = 1; i < l; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[target];
    }
}
