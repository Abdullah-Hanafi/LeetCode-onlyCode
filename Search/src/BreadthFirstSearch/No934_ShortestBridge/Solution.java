package BreadthFirstSearch.No934_ShortestBridge;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/15 18:18
 */
public class Solution {
    public int shortestBridge(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    //dfs标记其中一个岛屿
                    dfs(grid, i, j);
                    //从被标记过的岛屿进行bfs搜索
                    while (!bfs(grid)) {
                        answer++;
                    }
                    return answer;
                }
            }
        }
        return -1;
    }

    //dfs方法
    public void dfs(int[][] grid, int i, int j) {
        //递归出口
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) {
            return;
        }

        //标记岛屿
        grid[i][j] = 2;

        //下一层搜索
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

    public boolean isGrid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }

        //进行标记，标记为当前岛屿的邻海
        if (grid[i][j] == 0) {
            grid[i][j] = 3;
        }
        return false;
    }

    //bfs搜索
    public boolean bfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                //如果在被标记的岛屿上
                if (grid[i][j] == 2) {
                    //并且该位置四周正好为另一个岛屿
                    if (isGrid(grid, i, j - 1) || isGrid(grid, i, j + 1) || isGrid(grid, i - 1, j) || isGrid(grid, i + 1, j)) {
                        return true;
                    }
                }
            }
        }

        //岛屿周围都不是岛屿就要将邻海填海变成自己的岛屿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 3) {
                    grid[i][j] = 2;
                }
            }
        }
        return false;
    }

}