package OneDimensional.No53_MaximumSubarray;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/28 10:18
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

//    public int maxSubArray(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int prev = nums[0];
//        int max = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            prev = Math.max(nums[i],prev + nums[i]);
//            max = Math.max(prev,max);
//        }
//        return max;
//    }

}

