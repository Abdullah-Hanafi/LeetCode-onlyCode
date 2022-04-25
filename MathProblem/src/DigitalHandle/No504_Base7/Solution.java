package DigitalHandle.No504_Base7;

public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }

        String ans = "";
        while (num != 0) {
            ans = num % 7 + ans;
            num /= 7;
        }
        return isNegative ? ("-" + ans) : ans;
    }
}
