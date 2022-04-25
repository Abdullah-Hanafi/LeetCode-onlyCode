package Exercise.No633_SumofSquareNumbers;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(4));
    }

    public static boolean judgeSquareSum(int c) {
        int high = (int) Math.sqrt(c);
        int low = 0;

        boolean flag = false;
        while (low <= high) {
            if (low * low + high * high == c) {
                flag = true;
                break;
            } else if (low * low + high * high < c) {
                low++;
            } else {
                high--;
            }
        }
        return flag;
    }
}
