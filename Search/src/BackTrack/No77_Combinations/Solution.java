package BackTrack.No77_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/14 11:45
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //边界考虑
        if (n < k || k <= 0) {
            return null;
        }
        //返回的答案
        List<List<Integer>> answer = new ArrayList<>();
        //模拟遍历树的路径
        List<Integer> path = new ArrayList<>();
        //题目要求第一个数字是1
        int begin = 1;
        backTrack(n, k, begin, path, answer);
        return answer;
    }

    public void backTrack(int n, int k, int begin, List<Integer> path, List<List<Integer>> answer) {
        //如果路径长度等于k的时候递归出口
        if (path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }

        //开始抓阄，最开始从1开始抓
        for (int i = begin; i <= n; i++) {
            //抓进去
            path.add(i);

            //抓下一个数字
            backTrack(n, k, i + 1, path, answer);

            //状态回改
            path.remove(path.size() - 1);
        }

    }

}
