package Exercise.No4_MedianofTwoSortedArrays;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arrays = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arrays, 0, nums1.length);
        System.arraycopy(nums2, 0, arrays, nums1.length, nums2.length);
        Arrays.sort(arrays);
        int al = arrays.length;
        double ans = 0;
        if (al == 0) return 0;
        if (al % 2 == 1) {
            ans = arrays[al / 2] / 1.0;
        } else {
            ans = (arrays[al / 2] + arrays[al / 2 - 1]) / 2.0;
        }
        return ans;
    }
}
