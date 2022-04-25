package No_496下一个更大元素;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] ans = new int[l1];

        for (int i = 0; i < l1; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < l1; i++) {
            int target = nums1[i];
            int index = search(target, nums2);

            for (int j = index + 1; j < l2; j++) {
                if (nums2[j] > target) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    public int search(int target, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
