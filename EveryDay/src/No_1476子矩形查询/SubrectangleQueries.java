package No_1476子矩形查询;

import java.util.ArrayList;

class SubrectangleQueries {
    int[][] rectangle;
    ArrayList<int[]> history;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.history = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        history.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int i = history.size()-1; i >= 0; i--) {
            int[] item = history.get(i);
            if (item[0] <= row && item[2] >= row && item[1] <= col && item[3] >= col) {
                return item[4];
            }
        }
        return this.rectangle[row][col];
    }
}
