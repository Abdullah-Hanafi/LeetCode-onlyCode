package BreadthFirstSearch.No207_CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/2 17:02
 * ��������
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //�������
        int[] inDegree = new int[numCourses];

        //ͳ��ÿ���ڵ�����
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }

        //�����Ϊ0�Ľڵ�������
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