package No438_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/5 11:40
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (p.length() > s.length()) return list;
        int[] conunt = new int[26];
        for (char c : p.toCharArray()) {
            conunt[c - 'a']++;
        }
        int left = 0;
        int right = p.length() - 1;
        while (right < s.length()) {
            int[] answer = new int[26];
            String sub = s.substring(left, right + 1);
            for (char c : sub.toCharArray()) {
                answer[c - 'a']++;
            }
            if (Arrays.equals(answer, conunt)) {
                list.add(left);
            }
            left++;
            right++;
        }
        return list;
    }
}