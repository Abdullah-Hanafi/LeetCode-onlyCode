package No567_字符串的排列;

import java.util.Arrays;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/5 11:41
 */
public class Solution {
    /**
     * 双指针维护的滑动窗口
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] conunt = new int[26];
        for (char c : s1.toCharArray()) {
            conunt[c - 'a']++;
        }
        int left = 0;
        int right = s1.length() - 1;
        boolean flag = false;
        while (right < s2.length()) {
            int[] answer = new int[26];
            String s = s2.substring(left, right + 1);
            for (char c : s.toCharArray()) {
                answer[c - 'a']++;
            }
            if (Arrays.equals(answer, conunt)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}