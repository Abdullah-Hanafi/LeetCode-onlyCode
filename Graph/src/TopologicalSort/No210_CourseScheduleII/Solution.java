package TopologicalSort.No210_CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/26 11:05
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //答案数组
        int[] result = new int[numCourses];

        //记录每个节点的入度数组
        int[] inDegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }
        //记录所有入度为0的点
        Queue<Integer> queue = new LinkedList<>();

        //将所有入度为0的节点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //答案数组的下标
        int index = 0;
        while (!queue.isEmpty()) {
            //取出队列节点
            int node = queue.poll();
            //加入答案
            result[index++] = node;

            //遍历每条边
            for (int[] edge : prerequisites) {
                //该节点是start节点,删除边，并将end节点的入度减1
                if (edge[1] == node) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        queue.add(edge[0]);
                    }
                }
            }

        }
        return index == numCourses ? result : new int[]{};
    }
}