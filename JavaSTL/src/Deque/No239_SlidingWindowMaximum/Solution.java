package Deque.No239_SlidingWindowMaximum;

import java.util.*;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/5 22:00
 */
public class Solution {
    /**
     * 超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        List<Integer> list = new ArrayList<>();
        while (right < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }
            list.add(max);
            right++;
            left++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] answer = new int[nums.length - k + 1];
        //遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            //保证从大到小，如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            //加入当前元素
            queue.add(i);

            //判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            //当前窗口为K时，保存当前窗口中的最大值
            if (i + 1 >= k) {
                answer[i - k + 1] = nums[queue.peek()];
            }
        }
        return answer;
    }

}
