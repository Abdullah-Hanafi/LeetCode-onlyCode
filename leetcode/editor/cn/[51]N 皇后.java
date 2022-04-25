//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1248 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        //判断每列是否有皇后
        boolean[] column = new boolean[n];
        //判断y=x是否有皇后
        boolean[] left = new boolean[2 * n - 1];
        //判断y=-x是否有皇后
        boolean[] right = new boolean[2 * n - 1];
        //初始化棋盘
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        backtracking(paths, path, grid, 0, n, column, left, right);
        return paths;
    }

    public void backtracking(List<List<String>> paths, List<String> path, char[][] grid, int row, int n, boolean[] column, boolean[] left, boolean[] right) {
        if (row == n) {
            for (int i = 0; i < n; i++) {
                path.add(new String(grid[i]));
            }
            paths.add(new ArrayList<>(path));
            path.clear();
            return;
        }

        //遍历row行的每一列
        for (int col = 0; col < n; col++) {
            //判断当前位置是否可以放皇后，如果不能放就直接剪枝
            if (column[col] || left[row + col] || right[col - row + n - 1]) continue;

            grid[row][col] = 'Q';
            column[col] = true;
            left[row + col] = true;
            right[col - row + n - 1] = true;

            backtracking(paths, path, grid, row + 1, n, column, left, right);

            grid[row][col] = '.';
            column[col] = false;
            left[row + col] = false;
            right[col - row + n - 1] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
