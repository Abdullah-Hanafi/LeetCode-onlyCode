package No209_长度最小的子数组;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/2 11:55
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int min = Integer.MAX_VALUE;
        int answer = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            answer += nums[right];
            while (answer >= target && left <= right) {
                min = Math.min(min, right - left + 1);
                answer -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
