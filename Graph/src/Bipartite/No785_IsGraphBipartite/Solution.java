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
        //边界检查
        if (graph.length == 0) return true;
        //0表示为访问，1表示红色，2表示绿色
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        //遍历图中每个节点i
        for (int i = 0; i < graph.length; i++) {
            //节点i未访问
            if (color[i] == 0) {
                //加入访问队列
                queue.add(i);
                //设置颜色
                color[i] = 1;
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                //访问当前节点的所有邻接节点
                for (int j : graph[current]) {
                    //邻接节点未访问
                    if (color[j] == 0) {
                        queue.add(j);
                        //设置与当前节点不同的颜色
                        color[j] = (color[current] == 1 ? 2 : 1);
                    } else if (color[current] == color[j]) {
                        //邻接节点访问过了，且和当前节点颜色相同
                        return false;
                    }
                }
            }
        }
        return true;
    }

}