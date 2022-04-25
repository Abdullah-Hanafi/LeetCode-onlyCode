package DivideType.No91_DecodeWays;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/10 11:01
 */
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        //dp[i]表示以s.charAt(i-1)结尾的字符串的数字表示的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            //最后一个字符单独映射
            if (s.charAt(i - 1) != '0') {
                //直接dp[0]初始化为1，不用++
                dp[i] += dp[i - 1];
            }
            //最后两个字符同时映射
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 1) - '0') + (s.charAt(i - 2) - '0') * 10 <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}