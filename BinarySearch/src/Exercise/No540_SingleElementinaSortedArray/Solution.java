package Exercise.No540_SingleElementinaSortedArray;

public class Solution {
    /**
     * 方法一：抑或
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    /**
     * 方法二：二分查找
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            boolean isEven = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    /**
     * 方法三：二分查找只找偶数下标
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]){
                left = mid + 2;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}