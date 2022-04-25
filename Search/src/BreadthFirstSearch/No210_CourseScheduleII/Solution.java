package BreadthFirstSearch.No210_CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/2 16:56
 * ��������
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //������
        int[] answer = new int[numCourses];

        //�������
        int[] inDegree = new int[numCourses];
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
            //ȡ��һ����Ϊ0�Ľڵ㣬��һ���γ�
            int node = queue.poll();
            //���γ̼�����з�����
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