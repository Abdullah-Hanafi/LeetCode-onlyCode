package Exercise.No680_ValidPalindromeII;

public class Solution {
    /**
     * 方法一：双指针+递归
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            //如果相等则指针移动
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                //不相等就删除一个字符判断是否是回文串
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        //循环正常出来说明，说明没有删除字符
        return true;
    }

    //判断字符串的子串是否是回文串
    public boolean validPalindrome(String s, int low, int high) {
        int left = low;
        int right = high;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
