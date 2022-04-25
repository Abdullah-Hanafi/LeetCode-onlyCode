package Before.No704_BinarySearch;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/6 16:12
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] > target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }

}