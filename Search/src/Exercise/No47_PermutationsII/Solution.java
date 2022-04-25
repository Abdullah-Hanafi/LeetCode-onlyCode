package Exercise.No47_PermutationsII;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/20 12:03
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        int length = nums.length;
        if (length == 0 || nums == null) return answer;

        for (int num : nums) {
            temp.add(num);
        }
        backTrack(length, temp, set, answer, 0);
        return answer;
    }

    public void backTrack(int length, List<Integer> temp, Set<List<Integer>> set, List<List<Integer>> answer, int current) {
        if (current == length) {
            if (set.add(new ArrayList<>(temp))) {
                answer.add(new ArrayList<>(temp));
            }
        }

        for (int i = current; i < length; i++) {
            Collections.swap(temp, current, i);
            backTrack(length, temp, set, answer, current + 1);
            Collections.swap(temp, current, i);
        }
    }
}
