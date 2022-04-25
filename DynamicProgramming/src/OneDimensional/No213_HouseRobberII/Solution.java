package OneDimensional.No213_HouseRobberII;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/28 9:43
 */
public class Solution {
    public int rob(int[] nums) {
        int num = nums.length;
        if (num == 1) {
            return nums[0];
        }
        if (num == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(help(nums, 0, num - 2), help(nums, 1, num - 1));
    }

    public int help(int[] nums, int begin, int end) {
        int[] dp = new int[end + 1];
        dp[begin] = nums[begin];
        dp[begin + 1] = Math.max(nums[begin], nums[begin + 1]);
        for (int i = begin + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
