package RandomAndSampling.No384_ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[] nums;
    private int[] origin;

    public Solution(int[] nums) {
        this.nums = nums;
        this.origin = nums.clone();
    }

    public int[] reset() {
        return this.origin;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(i, random.nextInt(nums.length - i) + i);
        }
        return nums;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
