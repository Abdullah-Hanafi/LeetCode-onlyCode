//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 363 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int x =0, y=0 , z = 0;
        for (int i = 1; i < n; i++){
            int n2 = dp[x]*2;
            int n3 = dp[y]*3;
            int n5 = dp[z]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (n2 == dp[i]) x++;
            if (n3 == dp[i]) y++;
            if (n5 == dp[i]) z++;
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
