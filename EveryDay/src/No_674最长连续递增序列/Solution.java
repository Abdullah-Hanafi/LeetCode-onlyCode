package No_674最长连续递增序列;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;

        for(int i = 1; i < length; i++){
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i] , max);
            }else{
                dp[i] = 1;
                max = Math.max(dp[i] , max);
            }
        }

        return max;
    }
}