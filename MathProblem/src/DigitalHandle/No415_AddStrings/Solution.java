package DigitalHandle.No415_AddStrings;

import java.util.Arrays;

public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int addBit = 0;
        String ans = "";
        while (i >= 0 || j >= 0 || addBit != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + addBit;
            ans = result % 10 + ans;
            addBit = result / 10;
            i--;
            j--;
        }
        return ans;
    }
}
