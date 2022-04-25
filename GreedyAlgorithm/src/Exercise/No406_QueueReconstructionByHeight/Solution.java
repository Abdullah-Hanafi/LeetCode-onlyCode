package Exercise.No406_QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 我看到这个题目的时候是一点思路都没有
 */
public class Solution {
    /**
     * 先对输入数组排序，h升序，k降序
     * 从头循环遍历 当前这个人就是剩下未安排的人中最矮的人，他的k值就代表他在剩余空位的索引值
     * 如果有多个人高度相同，要按照k值从大到小领取索引值 示例：
     * [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
     * [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
     * [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
     * [ 1, 3, 5 ]          [ 6, 1 ] 3
     * [ 1, 5 ]             [ 7, 1 ] 5
     * [ 1 ]                [ 7, 0 ] 1
     * [ [ 5, 0 ], [ 7, 0 ], [ 5, 2 ], [ 6, 1 ], [ 4, 4 ], [ 7, 1 ] ]
     *
     * @param people
     * @return
     */

    public static int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        Arrays.sort(people, (int[] p1, int[] p2) -> p1[0] == p2[0] ? p2[1] - p1[1] : p1[0] - p2[0]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(i);
        }


        int[][] answer = new int[length][2];
        for (int i = 0; i < people.length; i++) {
            int k = people[i][1];
            int index = list.remove(k);
            answer[index][0] = people[i][0];
            answer[index][1] = people[i][1];
        }
        return answer;
    }
}
