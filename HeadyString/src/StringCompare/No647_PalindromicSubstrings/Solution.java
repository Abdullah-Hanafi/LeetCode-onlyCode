package StringCompare.No647_PalindromicSubstrings;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/15 20:14
 */
public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //字符串长度是奇数
            count += countSubstrings(s, i, i);

            //字符串长度是偶数
            count += countSubstrings(s, i, i + 1);
        }
        return count;
    }

    public int countSubstrings(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
            count++;
        }
        return count;
    }
}
