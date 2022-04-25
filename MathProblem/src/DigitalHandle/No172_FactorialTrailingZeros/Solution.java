package DigitalHandle.No172_FactorialTrailingZeros;

public class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            count += (n / 5);
            n = n / 5;
        }

        return count;
    }

    public int trailingZeroes1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes1(n / 5);
    }
    //参考答案：
    //https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
}
