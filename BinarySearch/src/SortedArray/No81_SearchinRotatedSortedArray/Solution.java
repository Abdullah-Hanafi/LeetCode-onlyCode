package SortedArray.No81_SearchinRotatedSortedArray;

public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return true;
            }

            //当中间值和左侧值相同时，我们无法判断左侧全部相同还是右测全部相同
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[left] <= nums[mid]) {
                //左边有序，且数字在左边
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边有序，且数字在右边
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}