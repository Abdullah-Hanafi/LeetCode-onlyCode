package DepthFirstSearch.No695_MaxAreaOfIsland;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, isVisited, grid));
            }
        }
        return ans;
    }


    public int dfs(int i, int j, boolean[][] isVisited, int[][] grid) {
        //下标越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        //已经访问过
        if (isVisited[i][j]) {
            return 0;
        }

        //是海洋，不是岛屿
        if (grid[i][j] == 0) {
            return 0;
        }
        //没有访问过，可以进行操作了
        isVisited[i][j] = true;
        int ans = 1;
        ans += dfs(i - 1, j, isVisited, grid);
        ans += dfs(i + 1, j, isVisited, grid);
        ans += dfs(i, j - 1, isVisited, grid);
        ans += dfs(i, j + 1, isVisited, grid);
        return ans;
    }
}