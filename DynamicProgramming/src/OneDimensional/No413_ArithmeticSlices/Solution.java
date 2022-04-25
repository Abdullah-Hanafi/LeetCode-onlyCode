package OneDimensional.No413_ArithmeticSlices;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/4 9:49
 */
public class Solution {
//    public int numberOfArithmeticSlices(int[] nums) {
//        int length = nums.length;
//        if (length <= 2) {
//            return 0;
//        }
//        int sum = 0;
//        int[] dp = new int[length + 1];
//        for (int i = 2; i < length; i++) {
//            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
//                dp[i] = dp[i - 1] + 1;
//                sum += dp[i];
//            }
//        }
//        return sum;
//    }

    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return 0;
        }
        int sum = 0;
        int prev = 0;
        for (int i = 2; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                prev = prev + 1;
                sum += prev;
            } else {
                prev = 0;
            }
        }
        return sum;
    }
}