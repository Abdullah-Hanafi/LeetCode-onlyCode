package TwoSum.No167_TwoSumInputarraissorted;

public class Solution {

    /**
     * 双指针：非常简单
     * target>sum low++
     * target<sum high--
     * target == sum return
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return null;
    }

    /**
     * 方法二：二分查找
     * 每次固定一个数numbers[i]，然后在剩余的空间里[i+1,numbers.length-1]用二分查找寻找target-numbers[i]
     */
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return null;
    }

}
