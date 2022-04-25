package Offer_42连续子数组的最大和;

/*
//不太好理解
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;  //如果之前的连续子数组的和非正，则另起一个元素作为子数组的开头
            } else {
                sum += num; //如果之前的连续子数组的和是正数，则将元素加入该子数组
            }
            max = Math.max(max, sum); //取子数组的最大和
        }
        return max;
    }
}
*/


class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        //dp数组含义：当前下标为结尾的子数组的最大和
        dp[0] = nums[0];
        int max = dp[0]; //初始化一个最大子数组和

        for (int i = 1; i < nums.length; i++) {
            //判断当前元素是否应该拼接到前面的子数组中。如果当前元素拼接到前面子数组中更大则拼接。否则作为新的子数组的第一个元素
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);    //更新当前最大子数组的和

        }
        return max; //返回最大值

    }
}