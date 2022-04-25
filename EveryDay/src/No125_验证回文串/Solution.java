package No125_验证回文串;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/7 14:14
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            } else {
                char l = Character.toLowerCase(s.charAt(left++));
                char r = Character.toLowerCase(s.charAt(right--));
                if (l != r) return false;
            }
        }
        return true;
    }
}