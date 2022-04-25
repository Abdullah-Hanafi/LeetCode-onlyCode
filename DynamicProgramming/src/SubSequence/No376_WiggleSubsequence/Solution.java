package SubSequence.No376_WiggleSubsequence;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/29 11:49
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        if (length == 2 && nums[0] != nums[1]) {
            return 2;
        }
        if (length == 2 && nums[0] == nums[1]) {
            return 1;
        }

        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        if (nums[0] != nums[1]) dp[1] = 2;

        for (int i = 2; i < length; i++) {
            for (int j = i - 1; j >= 1; j--){
                if ((nums[i]-nums[j])*(nums[j]-nums[j-1])<0){
                    dp[i] = Math.max(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}
