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
                    //dfs�������һ������
                    dfs(grid, i, j);
                    //�ӱ���ǹ��ĵ������bfs����
                    while (!bfs(grid)) {
                        answer++;
                    }
                    return answer;
                }
            }
        }
        return -1;
    }

    //dfs����
    public void dfs(int[][] grid, int i, int j) {
        //�ݹ����
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) {
            return;
        }

        //��ǵ���
        grid[i][j] = 2;

        //��һ������
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

        //���б�ǣ����Ϊ��ǰ������ں�
        if (grid[i][j] == 0) {
            grid[i][j] = 3;
        }
        return false;
    }

    //bfs����
    public boolean bfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                //����ڱ���ǵĵ�����
                if (grid[i][j] == 2) {
                    //���Ҹ�λ����������Ϊ��һ������
                    if (isGrid(grid, i, j - 1) || isGrid(grid, i, j + 1) || isGrid(grid, i - 1, j) || isGrid(grid, i + 1, j)) {
                        return true;
                    }
                }
            }
        }

        //������Χ�����ǵ����Ҫ���ں������Լ��ĵ���
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