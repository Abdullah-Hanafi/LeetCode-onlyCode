package BackTrack.No40_CombinationSumII;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/20 20:14
 * 整体思路：（忍者算法）
 * 画回溯树，画完就会了
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(candidates, target, answer, temp, 0);
        return answer;

    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> answer, List<Integer> temp, int start) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                backtracking(candidates, target - candidates[i], answer, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
            while (i != candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
