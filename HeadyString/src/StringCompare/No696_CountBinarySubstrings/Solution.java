package StringCompare.No696_CountBinarySubstrings;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/15 21:17
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        //previous表示当前字符之前的连续字符的长度。且该连续字符与当前字符不同
        int previous = 0;

        //current表示当前字符的连续长度，初始化为1，表示s.charAt(0)
        int current = 1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            //依然是当前连续字符
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
                //不是当前连续字符了
            } else {
                previous = current; //当前的连续字符变成了之前的
                current = 1;
            }

            //只有之前的连续字符的长度>=当前连续字符的长度时，count++
            if (previous >= current) {
                count++;
            }
        }
        return count;
    }
}
