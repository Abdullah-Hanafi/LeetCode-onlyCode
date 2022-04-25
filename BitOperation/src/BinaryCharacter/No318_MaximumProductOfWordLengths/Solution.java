package BinaryCharacter.No318_MaximumProductOfWordLengths;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();

        //
        for (String word : words) {
            int bitMask = 0;
            for (char c : word.toCharArray()) {
                bitMask |= 1 << (c - 'a');
            }
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), word.length()));
        }

        int maxProd = 0;
        for (Integer integer : map.keySet()) {
            for (Integer integer1 : map.keySet()) {
                if ((integer & integer1) == 0){
                    maxProd = Math.max(maxProd,map.get(integer) * map.get(integer1));
                }
            }
        }
        return maxProd;
    }
}
