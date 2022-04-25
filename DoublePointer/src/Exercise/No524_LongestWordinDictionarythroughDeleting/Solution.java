package Exercise.No524_LongestWordinDictionarythroughDeleting;

import java.util.List;

public class Solution {
    /**
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        if (s.length() == 0 || dictionary.size() == 0){
            return "";
        }
        char[] charArrayS = s.toCharArray();
        String ans = "";
        for (String s1 : dictionary) {
            int i = 0;
            int j = 0;
            char[] charArrayS1 = s1.toCharArray();
            while (i < s.length() && j < s1.length()) {
                if (charArrayS[i] == charArrayS1[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            if (j == s1.length()) {
                if (s1.length() > ans.length()) {
                    ans = s1;
                } else if (s1.length() == ans.length()) {
                    ans = s1.compareTo(ans) < 0 ? s1 : ans;
                }
            }

        }
        return ans;
    }
}
