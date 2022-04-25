package BreadthFirstSearch.No210_CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/2 16:56
 * 拓扑排序
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //答案数组
        int[] answer = new int[numCourses];

        //入度数组
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }

        //将入度为0的节点加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            //取出一个度为0的节点，即一个课程
            int node = queue.poll();
            //将课程加入可行方案中
            answer[index++] = node;

            for (int[] edge : prerequisites) {
                if (edge[1] == node) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        return index == numCourses ? answer : new int[]{};
    }
}