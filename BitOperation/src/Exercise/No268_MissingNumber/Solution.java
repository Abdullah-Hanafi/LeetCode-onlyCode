package Exercise.No268_MissingNumber;

public class Solution {
    public int missingNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            answer ^= i;
        }

        for (int num : nums) {
            answer ^= num;
        }
        return answer;
    }
}
