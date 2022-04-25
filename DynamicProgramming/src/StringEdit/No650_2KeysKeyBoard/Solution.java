package StringEdit.No650_2KeysKeyBoard;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/25 17:00
 */
public class Solution {
    public static int minSteps(int n) {
        //dp[i]��ʾ��i��A�Ĳ�������,��Ȼdp[1]=0
        int[] dp = new int[n + 1];
        //dp[0]��dp[1]�Ѿ��������������2��ʼ����
        for (int i = 2; i < n + 1; i++) {
            //��ʼ��dp[i]�����ֵ,1��copy��i-1��paste
            dp[i] = i;
            for (int j = 2; j * j <= i; j++) {
                //���j��i�����ӣ���ô����������dp[j],Ȼ��1��copy��i/j-1��ճ��
                //����������dp[i/j],Ȼ��1��copu��j-1��ճ��
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
                    dp[i] = Math.min(dp[i / j] + j, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
