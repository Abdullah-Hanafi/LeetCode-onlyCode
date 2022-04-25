package Exercise.No260_SingleNumberIII;

import java.util.*;

public class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                ans[index++] = entry.getKey();
            }
        }
        return ans;
    }

    public int[] singleNumber1(int[] nums) {
        //求所有数异或之后得结果，这个结果是两个不同的数异或的结果
        int answer = 0;
        for (int num : nums) {
            answer ^= num;
        }

        //找出该结果任意一位为1的位，即第k位为1
        int k = -1;
        for (int i = 0; i <= 31 && k == -1; i++) {
            if ((answer >> i & 1) == 1) {
                k = i;
            }
        }

        //根据第k位为1可以将nums中所有的数字分为两组，且两个不同的数字必定不在一组
        int[] single = new int[2];
        for (int num : nums) {
            if ((num >> k & 1) == 1) {
                single[0] ^= num;
            } else {
                single[1] ^= num;
            }
        }
        return single;
    }
}

