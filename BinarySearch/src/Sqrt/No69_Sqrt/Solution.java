package Sqrt.No69_Sqrt;

public class Solution {

    public static void main(String[] args) {
        int number = mySqrt(8);
    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left +1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
