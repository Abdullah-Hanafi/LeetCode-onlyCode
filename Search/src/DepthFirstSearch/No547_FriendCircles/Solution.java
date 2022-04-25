package DepthFirstSearch.No547_FriendCircles;

public class Solution {
    /**
     * 方法一：深度优先搜索:先判断是否越界
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int l = isConnected.length;
        int count = 0;
        int[] visited = new int[l];
        for (int i = 0; i < l; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int[] visited, int i) {
        visited[i] = 1;
        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[i][k] == 1 && visited[k] == 0) {
                dfs(isConnected, visited, k);
            }
        }
    }

    /**
     * 方法二：深度优先搜索：先进行搜索，再判断是否越界
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        int l = isConnected.length;
        int count = 0;
        int[] visited = new int[l];
        for (int i = 0; i < l; i++) {
            if(visited[i] == 0){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs1(int[][] isConnected, int[] visited, int i) {
        if (visited[i] == 1) {
            return;
        }
        visited[i] = 1;

        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[i][k] == 1) {
                dfs1(isConnected, visited, k);
            }
        }
    }
}
