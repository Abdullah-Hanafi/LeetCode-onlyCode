package BreadthFirstSearch.No207_CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/2 17:02
 * 拓扑排序
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度数组
        int[] inDegree = new int[numCourses];

        //统计每个节点的入度
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
            int node = queue.poll();
            index++;
            for (int[] edge : prerequisites) {
                if (edge[1] == node) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        return index == numCourses ? true : false;
    }
}