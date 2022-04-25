package Exercise.No169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) > nums.length/2){
                answer = integer;
                break;
            }
        }
        return answer;
    }
}
