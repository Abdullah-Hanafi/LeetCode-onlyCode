package Exercise.No39_CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/20 15:22
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backTrack(candidates, target, answer, temp, 0);
        return answer;
    }

    public void backTrack(int[] candidates, int target, List<List<Integer>> answer, List<Integer> temp, int current) {
        if (current == candidates.length) {
            return;
        }

        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        //跳过当前数字
        backTrack(candidates, target, answer, temp, current + 1);

        //选择当前数字
        if (target - candidates[current] >= 0) {
            temp.add(candidates[current]);
            backTrack(candidates, target - candidates[current], answer, temp, current);
            temp.remove(temp.size() - 1);
        }
    }
}
