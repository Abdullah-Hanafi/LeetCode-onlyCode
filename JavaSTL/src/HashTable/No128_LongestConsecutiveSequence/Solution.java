package HashTable.No128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/7 19:39
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        //首先去个重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestLength = 0;
        for (Integer integer : set) {
            //如果set里没有integer-1，则说明integer是连续数组的起点
            if (!set.contains(integer - 1)) {
                int current = integer;
                int currentLength = 1;

                //判断最多连续的长度是多少
                while (set.contains(current + 1)) {
                    current += 1;
                    currentLength++;
                }

                longestLength = Math.max(currentLength, longestLength);
            }
        }
        return longestLength;
    }
}
