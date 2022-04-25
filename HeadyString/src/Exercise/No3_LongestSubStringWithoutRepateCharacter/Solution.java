package Exercise.No3_LongestSubStringWithoutRepateCharacter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/16 10:30
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length() && set.add(s.charAt(j)); j++) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
