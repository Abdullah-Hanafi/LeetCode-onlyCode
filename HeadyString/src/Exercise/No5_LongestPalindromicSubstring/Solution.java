package Exercise.No5_LongestPalindromicSubstring;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/16 10:42
 */
public class Solution {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = longestPalindrome(s, i, i);
            int length = temp.length();
            if (ans.length() < length) {
                ans = temp;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = longestPalindrome(s, i, i + 1);
            int length = temp.length();
            if (ans.length() < length) {
                ans = temp;
            }
        }
        return ans;
    }

    public String longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }
}
