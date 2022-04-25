package MergeTwoSortedArrays.No88_MergeSortedArrays;

import java.util.Arrays;

public class Solution {
    /**
     * 方法一：直接合并两个数组，然后排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 方法二：双指针
     * 一个指针指向nums1的第一个元素，一个指针指向nums2的第一个元素
     * 不断进行比较然后插入到新数组之中。
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            temp[i] = nums1[i];
        }

        int index1 = 0;
        int index2 = 0;
        int current = 0;

        while (index1 < m && index2 < n) {
            if (temp[index1] <= nums2[index2]) {
                nums1[current++] = temp[index1++];
            } else {
                nums1[current++] = nums2[index2++];
            }
        }

        while (index1 < m) {
            nums1[current++] = temp[index1++];
        }
        while (index2 < n) {
            nums1[current++] = nums2[index2++];
        }
    }

}
