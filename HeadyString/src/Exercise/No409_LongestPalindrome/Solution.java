package Exercise.No409_LongestPalindrome;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/16 8:52
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int answer = 0;
        for (Integer value : map.values()) {
            answer += value / 2 * 2;
            if (answer % 2 == 0 && value % 2 == 1) {
                answer++;
            }
        }
        return answer;
    }
}