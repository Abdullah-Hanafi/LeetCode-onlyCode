package BackTrack.No46_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> answer = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//
//        for (int num : nums) {
//            temp.add(num);
//        }
//
//        int l = nums.length;
//        backTrack(l, temp, answer, 0);
//        return answer;
//    }
//
//    /**
//     * @param length:全排列的数组的长度
//     * @param temp：用于每次进行操作的数组
//     * @param answer：全排列的所有结果
//     * @param current：把问题转化成在length个空格填数字，current表示当前要填充的位置，下标从0开始
//     */
//    public void backTrack(int length, List<Integer> temp, List<List<Integer>> answer, int current) {
//        //填完了所有的数字，所以当前为一种全排列的结果，需要将答案假如answer
//        //不能传入temp,因为传入temp其实是传入了地址，假如最后有6个全排列结果，也就是传入了6个地址，这6个地址里面肯定是相同的内容。也就是根节点的初始内容
//        if (current == length) {
//            answer.add(new ArrayList<>(temp));
//        }
//
//        //填充current个空格，当前[0，current-1]已填，[current,length-1]未填,用[current,length-1]中的数字填写第current个位置
//        for (int i = current; i < length; i++) {
//            //用第i个数填写current个数字，交换即可
//            Collections.swap(temp, current, i);
//            //继续填写下一个位置
//            backTrack(length, temp, answer, current + 1);
//            //回改状态
//            Collections.swap(temp, current, i);
//        }
//
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return answer;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        backtracking(answer, temp, nums, new boolean[nums.length]);
        return answer;
    }

    public void backtracking(List<List<Integer>> answer, List<Integer> temp, int[] nums, boolean[] isVistied) {
        if (temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && !isVistied[i - 1]) {
                continue;
            }
            if (!isVistied[i]) {
                temp.add(nums[i]);
                isVistied[i] = true;

                backtracking(answer, temp, nums, isVistied);

                isVistied[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
