package DepthFirstSearch.No417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        //记录坐标地是否到达太平洋、大西洋
        //初始化每个位置都无法到达太平洋
        boolean[][] canReachP = new boolean[m][n];
        //初始化每个位置都无法到达大西洋
        boolean[][] canReachA = new boolean[m][n];

        //遍历二维数组的左右两条边界
        for (int i = 0; i < m; i++) {
            dfs(heights, canReachP, i, 0);
            dfs(heights, canReachA, i, n - 1);
        }

        //遍历二维数组的上下两条边界
        for (int i = 0; i < n; i++) {
            dfs(heights, canReachP, 0, i);
            dfs(heights, canReachA, m - 1, i);
        }

        //遍历一遍数组，统计可以同时到达太平洋和大西洋的位置并返回
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }


    public void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        //扫描过了，并且可达
        if (canReach[i][j]) {
            return;
        }

        canReach[i][j] = true;

        //能不能往上走
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i - 1, j);
        }

        //能不能往下走
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i + 1, j);
        }

        //能不能往左走
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j - 1);
        }

        //能不能往右走
        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j + 1);
        }
    }

}
