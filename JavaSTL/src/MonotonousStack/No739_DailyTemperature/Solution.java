package MonotonousStack.No739_DailyTemperature;

import java.util.Stack;

public class Solution {
    /**
     * 常规模拟
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()) {
                int preIndex = stack.peek();
                if (temperatures[i] <= temperatures[preIndex]) {
                    break;
                }
                stack.pop();
                answer[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return answer;
    }
}
