package SubSequence.No300_LongestIncreasingSubsequence;



/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/19 11:11
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;

        //dp[i]表示以i结尾的连续递增子序列的长度
        int[] dp = new int[l];
        for (int i = 0; i < l; i++) {
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
