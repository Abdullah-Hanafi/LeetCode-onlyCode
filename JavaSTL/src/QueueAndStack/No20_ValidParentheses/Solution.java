package QueueAndStack.No20_ValidParentheses;

import java.util.*;

public class Solution {
    /**
     * 方法一：自己实现的栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Integer> myMap = new HashMap<Character, Integer>() {{
            put('(', -1);
            put('{', -2);
            put('[', -3);
            put(')', 1);
            put('}', 2);
            put(']', 3);
        }};

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (myMap.get(s.charAt(i)) < 0) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && myMap.get(s.charAt(i)) + myMap.get(stack.peek()) == 0) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }


    /**
     * 方法二：答案实现
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
