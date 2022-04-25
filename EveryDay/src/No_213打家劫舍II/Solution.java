package No_213打家劫舍II;

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }else if(length == 2){
            return Math.max(nums[0],nums[1]);
        }else{
            return Math.max(maxMoney(nums,0,length-2) , maxMoney(nums, 1 , length-1));
        }
    }

    public int maxMoney(int[] nums,int start,int end){
        int first = nums[start];    //用于保存dp[i-2]
        int second = Math.max(first,nums[start + 1]);   //用于保存dp[i-1]
        for(int i = start + 2; i <= end; i++){
            int temp = second;
            second = Math.max(second, first + nums[i]); //不偷nus[i]是取dp[i-1]即second，偷nums[i]时，则不能偷dp[i-1]，只能偷dp[i-2]
            first = temp;   //更新dp[i-2]
        }
        return second;
    }
}
