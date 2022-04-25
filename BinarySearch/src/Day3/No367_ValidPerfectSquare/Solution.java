package Day3.No367_ValidPerfectSquare;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/8 12:02
 */
public class Solution {
    public static void main(String[] args) {
        boolean flag = isPerfectSquare(2147483647);
    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long answer = (long) mid * mid;
            if (answer == num) {
                return true;
            } else if (answer > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
