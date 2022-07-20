import sun.applet.resources.MsgAppletViewer;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/21 21:09
 * 拓扑排序
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (left <= right) {
            int pos = getPatition(nums, left, right);
            if (pos == target) {
                return nums[pos];
            } else if (pos > target) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return nums[left];
    }


    //对数组进行一次快速排序并返回其patition下标
    public int getPatition(int[] nums, int left, int right) {
        //随机找一个pivot
        int pos = new Random().nextInt(right - left) + left;
        swap(nums, pos, right);
        int pivot = nums[right];
        //定义第一个大于pivot的位置
        int patition = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, patition);
                patition++;
            }
        }
        swap(nums, right, patition);
        return patition;
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        String s = "new";
    }
}