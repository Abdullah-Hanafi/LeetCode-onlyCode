package BackTrack.No79_WordSearch;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/14 14:35
 */
public class Solution {
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