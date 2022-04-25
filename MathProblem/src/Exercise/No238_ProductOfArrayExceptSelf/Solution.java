package Exercise.No238_ProductOfArrayExceptSelf;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = new Solution().productExceptSelf(nums);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftProduct = new int[length];
        int[] rightProduct = new int[length];
        leftProduct[0] = 1;
        for (int i = 1; i < length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = leftProduct[i] * rightProduct[i];
        }
        return answer;
    }
}
