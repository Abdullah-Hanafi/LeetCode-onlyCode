package BasicProblem.No190_ReverseBits;

public class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            answer = answer | (n & 1) << (31 - i);
            n = n >> 1;
        }
        return answer;
    }
}
