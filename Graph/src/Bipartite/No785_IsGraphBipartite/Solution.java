package Bipartite.No785_IsGraphBipartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/26 9:23
 */
public class Solution {

    public boolean isBipartite(int[][] graph) {
        //�߽���
        if (graph.length == 0) return true;
        //0��ʾΪ���ʣ�1��ʾ��ɫ��2��ʾ��ɫ
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        //����ͼ��ÿ���ڵ�i
        for (int i = 0; i < graph.length; i++) {
            //�ڵ�iδ����
            if (color[i] == 0) {
                //������ʶ���
                queue.add(i);
                //������ɫ
                color[i] = 1;
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                //���ʵ�ǰ�ڵ�������ڽӽڵ�
                for (int j : graph[current]) {
                    //�ڽӽڵ�δ����
                    if (color[j] == 0) {
                        queue.add(j);
                        //�����뵱ǰ�ڵ㲻ͬ����ɫ
                        color[j] = (color[current] == 1 ? 2 : 1);
                    } else if (color[current] == color[j]) {
                        //�ڽӽڵ���ʹ��ˣ��Һ͵�ǰ�ڵ���ɫ��ͬ
                        return false;
                    }
                }
            }
        }
        return true;
    }

}