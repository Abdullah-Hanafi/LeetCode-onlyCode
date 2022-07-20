import sun.applet.resources.MsgAppletViewer;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/21 21:09
 * ��������
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


    //���������һ�ο������򲢷�����patition�±�
    public int getPatition(int[] nums, int left, int right) {
        //�����һ��pivot
        int pos = new Random().nextInt(right - left) + left;
        swap(nums, pos, right);
        int pivot = nums[right];
        //�����һ������pivot��λ��
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