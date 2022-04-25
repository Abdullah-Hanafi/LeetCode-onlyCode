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
        //��
        List<List<String>> answer = new ArrayList<>();
        //�߽翼��
        if (n == 0) return answer;
        //����һ�����̲���ʼ��
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        List<String> list = new ArrayList<>();

        //�з������飬true��ʾ�����лʺ�
        boolean[] column = new boolean[n];
        //��б�������飬true��ʾ����б�лʺ�
        boolean[] left = new boolean[2 * n - 1];
        //��б�������飬true��ʾ����б�лʺ�
        boolean[] right = new boolean[2 * n - 1];
        backTrack(answer, grid, list, column, left, right, n, 0);
        return answer;
    }

    public void backTrack(List<List<String>> answer, char[][] grid, List<String> list, boolean[] column, boolean[] left, boolean[] right, int n, int row) {
        //�ݹ����
        if (row == n) {
            for (int i = 0; i < n; i++) {
                list.add(new String(grid[i]));
            }
            answer.add(new ArrayList<>(list));
            list.clear();
            return;
        }

        //��ǰ�ǵ�row��,����ÿһ�У��ж�Ӧ�����Ķ��Żʺ�
        for (int col = 0; col < n; col++) {
            //��ǰ�в��ʺϷŻʺ�
            if (column[col] || left[col + row] || right[n - 1 + col - row]) continue;

            //����״̬
            grid[row][col] = 'Q';
            column[col] = true;
            left[col + row] = true;
            right[n - 1 + col - row] = true;

            //������һ��
            backTrack(answer, grid, list, column, left, right, n, row + 1);

            //����
            grid[row][col] = '.';
            column[col] = false;
            left[col + row] = false;
            right[n - 1 + col - row] = false;

        }
    }

}
