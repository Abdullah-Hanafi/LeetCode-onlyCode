package Array.No240_SearchA2DMatrixII;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
