package PrefixSum.No560_SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/8 21:51
 */
public class Solution {
    /**
     * 方法一：模拟枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            //对以下标i结尾的子数组逐个遍历求和
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 方法二：前缀和实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        //key为前缀和pre，value为前缀和pre出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }

}
