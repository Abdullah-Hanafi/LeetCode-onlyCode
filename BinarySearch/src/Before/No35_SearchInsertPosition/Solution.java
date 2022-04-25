package Before.No35_SearchInsertPosition;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/6 15:51
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 6, 7, 8};
        int index = searchInsert(nums, 4);
    }

    private static int searchInsert(int[] nums, int target) {
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
        return left;
    }
//    public static int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length;
//        while (left < right){
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target){
//                return mid;
//            }else if (nums[mid] > target){
//                right = mid - 1;
//            }else{
//                left = mid + 1;
//            }
//        }
//        return left;
//        //return right + 1;
//    }
}
