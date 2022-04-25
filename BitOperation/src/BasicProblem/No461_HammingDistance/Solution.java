package BasicProblem.No461_HammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int number = x ^ y;
        int count = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }
}
