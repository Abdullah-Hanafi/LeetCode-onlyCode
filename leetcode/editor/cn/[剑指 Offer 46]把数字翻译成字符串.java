//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 458 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        //dp[i]表示str[0...i-1]最多可以表示多少个字母
        int[] dp= new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < str.length() + 1; i++){
            String number = str.substring(i-2,i);
            if(number.compareTo("10") >= 0 && number.compareTo("25")<=0){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
