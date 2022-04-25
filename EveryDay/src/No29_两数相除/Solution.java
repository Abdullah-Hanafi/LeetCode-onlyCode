package No29_�������;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/2 10:24
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        //dividend��divisor������Integer.MIN_VALUE,ȡ����ֵ��ʱ����ܻ������������Ҫת��long
        long left = dividend;
        long right = divisor;
        //�𰸵ķ���
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
