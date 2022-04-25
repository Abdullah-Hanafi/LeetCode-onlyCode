package No29_两数相除;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/2 10:24
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        //dividend和divisor可能是Integer.MIN_VALUE,取绝对值的时候可能会溢出，所以需要转成long
        long left = dividend;
        long right = divisor;
        //答案的符号
        int flag = 1;
        long answer = 0;
        if (left < 0) {
            flag = -flag;
            left = -left;
        }
        if (right < 0) {
            flag = -flag;
            right = -right;
        }
        long weight;
        while (left >= right) {
            weight = 1;
            long temp = right;
            while (temp + temp <= left) {
                temp += temp;
                weight += weight;
            }
            left -= temp;
            answer += weight;
        }
        if (flag == -1) answer = -answer;
        return answer > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) answer;
    }
}
