package DivideType.No91_DecodeWays;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/10 11:01
 */
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        //dp[i]��ʾ��s.charAt(i-1)��β���ַ��������ֱ�ʾ�ĸ���
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            //���һ���ַ�����ӳ��
            if (s.charAt(i - 1) != '0') {
                //ֱ��dp[0]��ʼ��Ϊ1������++
                dp[i] += dp[i - 1];
            }
            //��������ַ�ͬʱӳ��
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 1) - '0') + (s.charAt(i - 2) - '0') * 10 <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}