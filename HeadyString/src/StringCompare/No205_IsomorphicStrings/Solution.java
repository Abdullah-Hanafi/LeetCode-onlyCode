package StringCompare.No205_IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/12 16:35
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sMap.get(sc) != tMap.get(tc)) {
                return false;
            }

            if (!sMap.containsKey(sc)) {
                sMap.put(sc, i + 1);
            }

            if (!tMap.containsKey(tc)) {
                tMap.put(tc, i + 1);
            }
        }
        return false;
    }
}
