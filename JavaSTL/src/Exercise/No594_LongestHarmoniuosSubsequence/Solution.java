package Exercise.No594_LongestHarmoniuosSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/11 19:08
 */
public class Solution {
    public int findLHS(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = true;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
                else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = false;
                }
            }

            if (!flag)
                res = Math.max(count, res);

        }
        return res;
    }

    //哈希
    public int findLHS1(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }
        }
        return res;
    }

    public int findLHS2(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1)) {
                res = Math.max(map.get(num) + map.get(num + 1), res);
            }
            if (map.containsKey(num - 1)) {
                res = Math.max(map.get(num) + map.get(num - 1), res);
            }
        }
        return res;
    }
}
