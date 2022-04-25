package NO_389找不同;
/*
给定两个字符串 s 和 t，它们只包含小写字母。

字符串t由字符串s随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。



示例 1：
输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。

示例 2：
输入：s = "", t = "y"
输出："y"

示例 3：
输入：s = "a", t = "aa"
输出："a"

示例 4：
输入：s = "ae", t = "aea"
输出："a"

提示：
0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母

 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        System.out.println(findTheDifference4(s, t));
    }

    public static char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        char[] sToChar = s.toCharArray();
        Arrays.sort(sToChar);

        char[] tToChar = t.toCharArray();
        Arrays.sort(tToChar);

        for (int i = 0; i < sToChar.length; i++) {
            if (sToChar[i] != tToChar[i]) {
                return tToChar[i];
            }
        }
        return tToChar[s.length()];
    }

    /**
     * 计数：
     * 首先遍历字符串 ss，对其中的每个字符都将计数值加 1；
     * 然后遍历字符串 tt，对其中的每个字符都将计数值减 1。
     * 当发现某个字符计数值为负数时，说明该字符在字符串t中出现的次数大于在字符串s中出现的次数，因此该字符为被添加的字符。
     */

    public static char findTheDifference1(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] == -1) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 求和：
     * 将字符串s中的每个字符的ASCII码的值求和，得到as
     * 将字符串t中的每个字符的ASCII码的值求和，得到at
     * 两者的差at - as即代表被添加的字符
     */
    public static char findTheDifference2(String s, String t) {
        int as = 0;
        int at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * 位运算：
     * 将字符串s中的每个字符的ASCII码的值求和，得到as
     * 将字符串t中的每个字符的ASCII码的值求和，得到at
     * 两者的差at - as即代表被添加的字符
     */
    public static char findTheDifference3(String s, String t) {
        int as = 0;
        int at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * 位运算
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符,使用位运算的技巧解决本题。
     * ^= ：两个二进制的对应位相同，结果为0，否则结果为1。所以偶数个相同的数字^=的结果是0，最后和那个单独的数字^=后得到的数字就是那个单独的数字
     */
    public static char findTheDifference4(String s, String t) {
        String st = s + t;
        int v = 0;
        for (int i = 0; i < st.length(); i++) {
            v ^= st.charAt(i);
        }
        return (char) v;
    }
}

