package Exercise.No75_SortColors;

public class Solution {
    //方法一：选择排序、插入排序、冒泡排序
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentMinIndex = i;
            int currentMin = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < currentMin) {
                    currentMin = nums[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                nums[currentMinIndex] = nums[i];
                nums[i] = currentMin;
            }
        }
    }
}
