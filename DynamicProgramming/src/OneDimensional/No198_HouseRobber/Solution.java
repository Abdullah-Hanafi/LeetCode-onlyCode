package OneDimensional.No198_HouseRobber;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/29 10:16
 */
public class Solution {
    public int rob(int[] nums) {
        //�߽翼��
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        //dp����:dp[i]��ʾ���ٵ���i������ʱ���������ٵ��������
        int[] dp = new int[nums.length];
        if (nums.length == 1){
            dp[0] = nums[0];
        }else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
        }


        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
