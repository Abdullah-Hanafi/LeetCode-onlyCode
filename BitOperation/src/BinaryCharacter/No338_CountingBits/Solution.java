package BinaryCharacter.No338_CountingBits;

public class Solution {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            counts[i] = count(i);
        }
        return counts;
    }

    /**
     * 令x = x & (x - 1);，该运算将x的二进制表示的最后一个1变成0。因此，对x重复该操作，直到x变成0，则操作次数即为x的「一比特数」
     *
     * @param n
     * @return
     */

    public int count(int n) {
        int number = 0;
        while (n > 0) {
            n = n & (n - 1);
            number++;
        }
        return number;
    }
}
