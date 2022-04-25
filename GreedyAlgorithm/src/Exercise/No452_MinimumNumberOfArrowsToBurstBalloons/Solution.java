package Exercise.No452_MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
    }

    /**
     * 方法一：贪心
     */
    public static int findMinArrowShots(int[][] points) {
        int length = points.length;
        //边界考虑
        if (points.length == 0 || points == null) {
            return 0;
        }
        //按照右坐标从小到大进行排序
        /**
         * [[-2147483646,-2147483645],[2147483646,2147483647]]就过不了了，这是因为差值过大而产生溢出。
         * sort的时候不要用a-b来比较，要用Integer.compare(a, b)，或者p1[1] < p2[1] ? -1 : 1
         *
         * 可以用lambda表达式进行改写上述比较器
         * Arrays.sort(points, (int[] p1, int[] p2) -> (p1[1] < p2[1] ? -1 : 1));
         */
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1] < p2[1] ? -1 : 1;
            }
        });

        int right = points[0][1];
        int count = 1;  //箭的数量

        //遍历剩余的区间
        for (int i = 1; i < length; i++) {
            //无重叠
            if (right < points[i][0]) {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }
}
