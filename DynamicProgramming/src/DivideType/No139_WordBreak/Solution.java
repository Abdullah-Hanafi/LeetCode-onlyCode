package DivideType.No139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/18 16:38
 */
public class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        int[] dp = new int[l + 1];
        dp[0] = 1;
        for (int i = 1; i < l + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[l];
    }
}
