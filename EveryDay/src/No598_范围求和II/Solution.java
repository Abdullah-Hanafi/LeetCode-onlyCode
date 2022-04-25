package No598_范围求和II;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/7 22:31
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m;
        int minb = n;
        for (int[] op : ops) {
            mina = Math.min(op[0], mina);
            minb = Math.min(op[1], minb);
        }
        return mina * minb;
    }
}
