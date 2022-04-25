package UnionFind.No684_RedundantConnection;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/28 19:19
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] oldBrother = new int[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) {
            oldBrother[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int boy1 = edge[0];
            int boy2 = edge[1];
            if (find(oldBrother, boy1) != find(oldBrother, boy2)) {
                union(oldBrother, boy1, boy2);
            } else {
                return edge;
            }
        }
        return new int[]{};
    }

    public int find(int[] oldBrother, int boy) {
        if (boy != oldBrother[boy]) oldBrother[boy] = find(oldBrother, oldBrother[boy]);
        return oldBrother[boy];
    }

    public void union(int[] oldBrother, int boy1, int boy2) {
        int oldBrother1 = oldBrother[boy1];
        int oldBrother2 = oldBrother[boy2];
        if (oldBrother1 == oldBrother2) return;
        oldBrother[oldBrother2] = oldBrother1;
    }
}