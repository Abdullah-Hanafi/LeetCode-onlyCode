package No_14最长公共子串;


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String ans = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++){
            ans = longestCommonPrefix(ans,strs[i]);
            if (ans.length() == 0){
                break;
            }
        }
        return ans;
    }

    public String longestCommonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < length && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }
        return s1.substring(0, index);
    }
}
