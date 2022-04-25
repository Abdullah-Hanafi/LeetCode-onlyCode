package interval.No435_NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Solution {
    /**
     * 方法一：贪心
     * 优先选择右坐标最小的且与前面区间不重合的区间，这样可以保证后面留下的空间更大容纳更多的区间
     * 对区间按照右坐标从小到大进行排序
     * 选择最小的右坐标的区间，遍历区间数组，依次选择与前面区间不重合的区间并更新右坐标的值
     * 边界考虑：当区间数组为空的时候，返回0
     * 如果有多个区间的右端点都同样最小怎么办？
     * 由于我们选择的是首个区间，因此在左侧不会有其它的区间，那么左端点在何处是不重要的，我们只要任意选择一个右端点最小的区间即可。
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int count = 1; //不重叠的数组个数
        int right = intervals[0][1];    //当前right值
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;    //不重叠数组+1
                right = intervals[i][1];    //更新right值
            }
        }
        return intervals.length - count;
    }

    /**
     * 方法二：动态规划
     * 按照区间左端点从小到大排序，时间超出限制
     */
    public static int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];   //按照区间左端点从小到大进行排序
            }
        });

        int[] f = new int[intervals.length];    //动态规划数组表示当fi作为最后一个区间时，不重合区间的最大数量
        Arrays.fill(f, 1);   //初始化最大的不重合的区间数量只有区间本身

        for (int i = 1; i < intervals.length; i++) {    //更新动态规划数组的值
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return intervals.length - Arrays.stream(f).max().getAsInt();
    }

    /**
     * 方法三：动态规划
     * 按照区间右端点从小到大排序，时间超出限制
     */
    public static int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];   //按照区间左端点从小到大进行排序
            }
        });

        int[] f = new int[intervals.length];    //动态规划数组，表示以fi为最后一个区间时，不重合区间的最大数量
        Arrays.fill(f, 1);   //初始化最大的不重合的区间数量只有区间本身
        for (int i = 1; i < intervals.length; i++) {    //更新动态规划数组的值
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        return intervals.length - Arrays.stream(f).max().getAsInt();
    }
}
