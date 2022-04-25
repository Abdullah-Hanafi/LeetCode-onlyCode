package No_453最小操作次数使数组元素相等;

import java.util.Arrays;

public class Solution {
    /**
     * 设移动之前数组的和为sum，移动的次数为m,移动之后所有数字为x
     * 则，sum + m * (n - 1 ) = m * x;
     * 移动之前最小值为min,则min + m = x; 代入上式得
     * m = sum - n * min
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = Arrays.stream(nums).sum();
        return sum - nums.length * min;
    }
}
