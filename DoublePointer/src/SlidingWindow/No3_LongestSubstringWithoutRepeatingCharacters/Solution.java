package SlidingWindow.No3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/8 14:03
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 0;
        while (left < s.length()) {
            Set<Character> set = new HashSet<>();
            if (left != 0) {
                set.remove(s.charAt(left));
            }
            while (right < s.length() && set.add(s.charAt(right))) {
                right++;
            }
            max = Math.max(right - left, max);
            left++;
        }
        return max;
    }
}
