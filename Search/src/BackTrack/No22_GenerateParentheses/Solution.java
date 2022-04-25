package BackTrack.No22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/20 18:29
 * 整体思路：
 * 1.以2为例画一个回溯树
 * 2.记录当前节点的左括号和右括号的数目
 * 3.如果左括号的数量小于n才可以加入左括号
 * 4.如果右括号的数量小于左括号的数量才可以加入右括号
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtracking(n, new StringBuffer(), res, 0, 0);
        return res;
    }

//    private void backtracking(int n, String path, List<String> res, int open, int close) {
//        //递归出口，总共2*n层
//        if (path.length() == 2 * n) {
//            res.add(path);
//            return;
//        }
//
//        //当左括号小于n的时候，可以添加左括号
//        if (open < n) {
//            backtracking(n, path + "(", res, open + 1, close);
//
//        }
//
//        //当右括号小于左括号的数目时，可以添加右括号
//        if (close < open) {
//            backtracking(n, path + ")", res, open, close + 1);
//        }
//
//    }

    //用StringBuffer实现
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