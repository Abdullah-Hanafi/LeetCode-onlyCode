package Exercise.No462_MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int medium = nums[nums.length / 2];
        int answer = 0;

        for (int num : nums) {
            answer += Math.abs(medium - num);
        }
        return answer;
    }
}
