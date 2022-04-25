package BackTrack.No51_NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/15 9:37
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        //答案
        List<List<String>> answer = new ArrayList<>();
        //边界考虑
        if (n == 0) return answer;
        //创建一个棋盘并初始化
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        List<String> list = new ArrayList<>();

        //列访问数组，true表示该列有皇后
        boolean[] column = new boolean[n];
        //左斜访问数组，true表示该左斜有皇后
        boolean[] left = new boolean[2 * n - 1];
        //右斜访问数组，true表示该右斜有皇后
        boolean[] right = new boolean[2 * n - 1];
        backTrack(answer, grid, list, column, left, right, n, 0);
        return answer;
    }

    public void backTrack(List<List<String>> answer, char[][] grid, List<String> list, boolean[] column, boolean[] left, boolean[] right, int n, int row) {
        //递归出口
        if (row == n) {
            for (int i = 0; i < n; i++) {
                list.add(new String(grid[i]));
            }
            answer.add(new ArrayList<>(list));
            list.clear();
            return;
        }

        //当前是第row行,遍历每一列，判断应该在哪儿放皇后
        for (int col = 0; col < n; col++) {
            //当前列不适合放皇后
            if (column[col] || left[col + row] || right[n - 1 + col - row]) continue;

            //更改状态
            grid[row][col] = 'Q';
            column[col] = true;
            left[col + row] = true;
            right[n - 1 + col - row] = true;

            //进入下一轮
            backTrack(answer, grid, list, column, left, right, n, row + 1);

            //回溯
            grid[row][col] = '.';
            column[col] = false;
            left[col + row] = false;
            right[n - 1 + col - row] = false;

        }
    }

}
