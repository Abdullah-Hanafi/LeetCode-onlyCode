//最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。 
// Paste（粘贴）：粘贴 上一次 复制的字符。 
// 
//
// 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
//解释：
//最初, 只有一个字符 'A'。
//第 1 步, 使用 Copy All 操作。
//第 2 步, 使用 Paste 操作来获得 'AA'。
//第 3 步, 使用 Paste 操作来获得 'AAA'。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数学 动态规划 👍 447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
