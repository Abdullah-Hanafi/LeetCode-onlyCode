package HashTable.No149_MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/7 20:14
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        //边界处理
        if (n <= 2) {
            return n;
        }

        int max = 0;
        //记录两个点的斜率，因为double存在精度问题，不便进行相等判断，所以用二元组dx和dy来表示两个点的斜率
        for (int i = 0; i < n; i++) {

            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                //当dx或dy为0的时候，dx和dy没有最大公约数，因此可以规定dx = 0 ， dy = 1； dy = 0， dx = 1
                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                } else {
                    //dx = -1 dy = 2和 dx = 1 dy = -2是一样的，因此可以规定dy不能为负数
                    if (dy < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    //存在dx = 1 dy = 2 和 dx = 2，dy = 4其实是在同一直线的情况，所以求dx和dy的最大公约数，让dx 和 dy分别除以最大公约数，将斜率的二元组化至最简
                    int gcdXY = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= gcdXY;
                    dy /= gcdXY;
                }
                //将二元组映射为一个key
                int key = dy + dx * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                max = Math.max(max, num + 1);
            }
        }
        return max;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
