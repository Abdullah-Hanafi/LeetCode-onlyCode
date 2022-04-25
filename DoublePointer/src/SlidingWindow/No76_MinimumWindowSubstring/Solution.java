package SlidingWindow.No76_MinimumWindowSubstring;

public class Solution {
    /**
     * 方法一：暴力求解
     * 枚举输入字符串s的所有长度大于等于t的子串，逐个判断这些子串中，哪些子串覆盖了字符串t的所有字符，并记录符合条件的最短子串
     * 如何判断s的子串包含了t中的所有字符？
     * 分别统计S的子串和T中每个字符出现的次数，然后逐个对比
     * 时间超时 237/266，我感觉可行
     *
     * @param s 主串
     * @param t 子串
     * @return 最小连续字串
     */
    public static String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        //边界考虑
        if (sl < tl || sl == 0 || tl == 0) {
            return "";
        }

        //记录t字符串中所有字符出现的次数
        int[] countT = new int[128];
        for (int i = 0; i < tl; i++) {
            countT[t.charAt(i)]++;
        }

        String ans = "";
        //遍历s中长度大于等于t的所有子串
        for (int i = 0; i < sl; i++) {
            for (int j = i + tl; j <= sl; j++) {
                String sub = s.substring(i, j);

                //统计sub字符串中所有字符出现的次数
                int[] countS = new int[128];
                for (int k = 0; k < sub.length(); k++) {
                    countS[sub.charAt(k)]++;
                }

                boolean flag = true;
                //判断字符串sub中是否包含t中所有字母
                for (int q = 0; q < 128; q++) {
                    if (countS[q] < countT[q]) {
                        flag = false;
                        break;
                    }
                }

                //记录sub，第一次记录的时候直接赋值给ans即可
                if (flag && ans.equals("")) {
                    ans = sub;
                }

                //第2次及其之后赋值要判断长度
                if (flag) {
                    if (ans.length() > sub.length()) {
                        ans = sub;
                    }
                }

            }
        }
        return ans;
    }

    /**
     * 方法二：滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow1(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl == 0 || tl == 0 || sl < tl) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        //滑动窗口内部包含多少T中的字符，对应字符频数超过不重复计算
        int distance = 0;
        int minLen = sl + 1;    //最小覆盖子串的长度
        int begin = 0;  //对应的起始位置下标

        //滑动窗口的指针，滑动窗口为左闭右开区间[left,right)，好处：right-legt正好为滑动窗口的长度
        int left = 0;
        int right = 0;

        //滑动窗口右边界先移动
        while (right < sl) {
            //先观察刚看到的字符charsArrayS[right]
            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;//滑动窗口中包含t中的字符增加
            }
            winFreq[charArrayS[right]]++;//将看到的字符加入滑动窗口中
            right++;//右指针右移


            //滑动窗口左边界移动
            //当滑动窗口包含了t中所有的字符时
            while (distance == tl) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]) {
                    distance--;
                }

                winFreq[charArrayS[left]]--;
                left++;

            }
        }

        if (minLen == sl + 1) {
            return "";
        }

        return s.substring(begin, begin + minLen);
    }
}
