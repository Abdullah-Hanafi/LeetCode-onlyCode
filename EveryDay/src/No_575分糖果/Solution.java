package No_575分糖果;

import java.util.*;

public class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int current = candyType[0];
        int type = 1;
        for (int i = 0; i < candyType.length; i++) {
            if (current != candyType[i]) {
                type++;
                current = candyType[i];
            }
        }

        return Math.min(candyType.length / 2, type);
    }

    public int distributeCandies1(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    public int distributeCandies2(int[] candyType) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : candyType) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return Math.min(map.size(), candyType.length / 2);
    }
}
