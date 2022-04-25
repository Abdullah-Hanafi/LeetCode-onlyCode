package Exercise.No217_ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/6 0:24
 */
public class Solution {
    //    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)){
//                return true;
//            }
//            set.add(num);
//        }
//        return false;
//    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
}
