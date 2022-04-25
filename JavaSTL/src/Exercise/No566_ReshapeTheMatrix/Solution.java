package Exercise.No566_ReshapeTheMatrix;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/6 0:00
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] answer = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            answer[i / c][i % c] = nums[i / n][i % n];
        }

        return answer;
    }
}
