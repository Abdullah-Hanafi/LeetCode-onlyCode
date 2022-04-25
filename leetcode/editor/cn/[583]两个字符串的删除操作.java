//给定两个单词 word1 和 word2 ，返回使得 word1 和 word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
// Related Topics 字符串 动态规划 👍 394 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return length1 + length2 - 2 * dp[length1][length2];
    }

//    public int minDistance(String word1, String word2) {
//        int length1 = word1.length();
//        int length2 = word2.length();
//        int[][] dp = new int[length1 + 1][length2 + 1];
//        for (int i = 1; i <= length1; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 1; j <= length2; j++) {
//            dp[0][j] = j;
//        }
//        for (int i = 1; i < length1 + 1; i++) {
//            for (int j = 1; j < length2 + 1; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                } else {
//                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+1;
//                }
//            }
//        }
//        return dp[length1][length2];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
