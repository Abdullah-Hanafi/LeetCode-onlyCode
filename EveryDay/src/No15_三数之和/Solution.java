package No15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/2 10:32
 */
public class Solution {
    /**
     * 排序
     * 用for循环固定第一个数字，用双指针找剩下的两个数字，并且剩下的两个数字和是第一个数字的相反数
     * 需要去重，首先是固定的第一个数字，出现重复直接跳过当前循环进入下一次循环。如：-1,-1,-1,2
     * 其次是双指针寻找两个数字时，如果已经找到了num[left] + nums[right] == -第一个数字，那么我们直接将与num[left]和num[right]相同的数字直接去重跳过
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //先来排序
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            //固定第一个数，如果上一个三元组的第一个数和当前的数字一样直接跳过
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    //找到了
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重nums[left]
                    int temp = nums[left];
                    while (nums[left] == temp && left < right) left++;

                    //去重nums[right]
                    temp = nums[right];
                    while (nums[right] == temp && left < right) right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answer;
    }
}
