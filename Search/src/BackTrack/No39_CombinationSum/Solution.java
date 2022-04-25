package BackTrack.No39_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/20 20:00
 * ����˼·��(�����㷨)
 * ��һ��������������ͻ���
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(0, target, temp, answer, candidates);
        return answer;
    }

    public void backtracking(int start, int target, List<Integer> temp, List<List<Integer>> answer, int[] candidates) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                backtracking(i, target - candidates[i], temp, answer, candidates);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
