package BackTrack.No47_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/21 14:00
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(answer, temp, nums, new boolean[nums.length]);
        return answer;
    }

    public void backtracking(List<List<Integer>> answer, List<Integer> temp, int[] nums, boolean[] isVisited) {
        if (temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && !isVisited[i - 1]) {
                continue;
            }
            if (!isVisited[i]) {
                temp.add(nums[i]);
                isVisited[i] = true;

                backtracking(answer, temp, nums, isVisited);

                isVisited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}