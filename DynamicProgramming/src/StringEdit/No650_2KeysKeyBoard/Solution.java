package StringEdit.No650_2KeysKeyBoard;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/25 17:00
 */
public class Solution {
    public static int minSteps(int n) {
        //dp[i]表示到i个A的操作步骤,显然dp[1]=0
        int[] dp = new int[n + 1];
        //dp[0]和dp[1]已经解决，接下来从2开始遍历
        for (int i = 2; i < n + 1; i++) {
            //初始化dp[i]的最大值,1次copy和i-1次paste
            dp[i] = i;
            for (int j = 2; j * j <= i; j++) {
                //如果j是i的因子，那么我们先生成dp[j],然后1次copy，i/j-1次粘贴
                //或者先生成dp[i/j],然后1次copu，j-1次粘贴
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
                    dp[i] = Math.min(dp[i / j] + j, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
