package StringComprehension.No227_BasicCalculatorII;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/15 21:26
 */
public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;    //记录s中的数字
        char preOp = '+';
        int length = s.length();

        for (int i = 0; i < length; i++) {
            //如果当前是数字，那么对数字进行记录
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            //若读到一个运算符，或者遍历到字符串末尾，即认为是遍历到了数字末尾。处理该数字
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == length - 1) {
                switch (preOp) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                //更新前面的运算符
                preOp = s.charAt(i);
                //更新数字
                num = 0;
            }
        }

        int answer = 0;

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;

    }
}
