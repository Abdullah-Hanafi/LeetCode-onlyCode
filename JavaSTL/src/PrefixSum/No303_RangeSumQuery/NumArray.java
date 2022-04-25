package PrefixSum.No303_RangeSumQuery;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/7 21:35
 */
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }


}
