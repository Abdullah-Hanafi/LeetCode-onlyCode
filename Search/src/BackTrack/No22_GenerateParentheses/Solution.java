package BackTrack.No22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/20 18:29
 * ����˼·��
 * 1.��2Ϊ����һ��������
 * 2.��¼��ǰ�ڵ�������ź������ŵ���Ŀ
 * 3.��������ŵ�����С��n�ſ��Լ���������
 * 4.��������ŵ�����С�������ŵ������ſ��Լ���������
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtracking(n, new StringBuffer(), res, 0, 0);
        return res;
    }

//    private void backtracking(int n, String path, List<String> res, int open, int close) {
//        //�ݹ���ڣ��ܹ�2*n��
//        if (path.length() == 2 * n) {
//            res.add(path);
//            return;
//        }
//
//        //��������С��n��ʱ�򣬿������������
//        if (open < n) {
//            backtracking(n, path + "(", res, open + 1, close);
//
//        }
//
//        //��������С�������ŵ���Ŀʱ���������������
//        if (close < open) {
//            backtracking(n, path + ")", res, open, close + 1);
//        }
//
//    }

    //��StringBufferʵ��
    private void backtracking(int n, StringBuffer temp, List<String> answer, int left, int right) {
        if (temp.length() == 2 * n) {
            answer.add(temp.toString());
            return;
        }

        if (left < n) {
            temp.append("(");
            backtracking(n, temp, answer, left + 1, right);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (left > right) {
            temp.append(")");
            backtracking(n, temp, answer, left, right + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}