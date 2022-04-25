package No_496NextGreaterElementI;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] res = new int[length1];

        if (length1 < 1) {
            return res;
        }

        for (int i = 0; i < length1; i++) {
            int curVal = nums1[i];

            int j = 0;
            while (j < length2 && nums2[j] != curVal) {
                j++;
            }

            j++;
            while (j < length2 && nums2[j] < curVal){
                j++;
            }

            if (j == length2){
                res[i] = -1;
            }else {
                res[i] = nums2[j];
            }
        }
        return res;

    }
}
