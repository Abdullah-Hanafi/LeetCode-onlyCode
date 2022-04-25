package No_300最长递增子序列;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        for(int i = 0; i < l; i++){
            dp[i] = 1;
        }

        int max = 1;
        for(int i = 1; i < l; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}