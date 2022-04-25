package Exercise.No503_NextGreaterElementII;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/9 11:02
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * l - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % l]) {
                ans[stack.pop()] = nums[i % l];

            }
            stack.push(i % l);
        }
        return ans;
    }
}
