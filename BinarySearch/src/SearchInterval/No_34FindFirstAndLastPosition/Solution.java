package SearchInterval.No_34FindFirstAndLastPosition;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,3,4,4,4,5};
        int low = low(nums, 4);
        System.out.println(low);
        int high = high(nums,4);
        System.out.println(high);
    }


    public static int low(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int high(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
