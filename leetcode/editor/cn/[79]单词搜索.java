//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1244 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean find = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find = backtracking(word, 0, board, i, j, visited);
                if (find) return true;
            }
        }
        return false;
    }


    public boolean backtracking(String word, int index, char[][] board, int i, int j, boolean[][] visited) {
        //下标越界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        //被访问过
        if (visited[i][j]) return false;

        //与当前字符不相等
        if (board[i][j] != word.charAt(index)) return false;

        if (index == word.length() - 1) return true;

        //修改状态
        visited[i][j] = true;

        boolean flag1 = backtracking(word, index + 1, board, i + 1, j, visited);
        if (flag1) return true;
        boolean flag2 = backtracking(word, index + 1, board, i - 1, j, visited);
        if (flag2) return true;
        boolean flag3 = backtracking(word, index + 1, board, i, j + 1, visited);
        if (flag3) return true;
        boolean flag4 = backtracking(word, index + 1, board, i, j - 1, visited);
        if (flag4) return true;

        visited[i][j] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
