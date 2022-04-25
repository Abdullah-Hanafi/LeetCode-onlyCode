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
        //������
        int[] result = new int[numCourses];

        //��¼ÿ���ڵ���������
        int[] inDegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }
        //��¼�������Ϊ0�ĵ�
        Queue<Integer> queue = new LinkedList<>();

        //���������Ϊ0�Ľڵ�������
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //��������±�
        int index = 0;
        while (!queue.isEmpty()) {
            //ȡ�����нڵ�
            int node = queue.poll();
            //�����
            result[index++] = node;

            //����ÿ����
            for (int[] edge : prerequisites) {
                //�ýڵ���start�ڵ�,ɾ���ߣ�����end�ڵ����ȼ�1
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