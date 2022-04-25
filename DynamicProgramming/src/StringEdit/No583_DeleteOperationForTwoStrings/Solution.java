package StringEdit.No583_DeleteOperationForTwoStrings;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/29 10:13
 */
public class Solution {
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
