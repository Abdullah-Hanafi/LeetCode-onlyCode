package Exercise.No307_RangeSumQuery;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/12 11:20
 */

/**
 * 用前缀和的实现究竟哪儿错了？？？？
 */
public class NumArray {
    private int[] nums;
    private int[] prefix;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
        setPrefix();
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public void setPrefix() {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
}

/**
 * 为什么线段树可以
 * https://leetcode-cn.com/problems/range-sum-query-mutable/comments/506651
 */
class NumArray1 {

    int[] tree;
    int[] nums;
    int n;

    public void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) >> 1;
        int left = node * 2 + 1;
        int right = node * 2 + 2;
        buildTree(left, start, mid);
        buildTree(right, mid + 1, end);
        tree[node] = tree[left] + tree[right];
    }

    public void updateTree(int idx, int node, int val, int start, int end) {
        if (start > end) return;
        if (start == end) {
            nums[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) >> 1;
            int left = node * 2 + 1;
            int right = node * 2 + 2;
            if (idx >= start && idx <= mid)
                updateTree(idx, left, val, start, mid);
            else
                updateTree(idx, right, val, mid + 1, end);

            tree[node] = tree[left] + tree[right];
        }
    }

    public int query(int L, int R, int node, int start, int end) {
        if (L > end || R < start) return 0;
        if (start == end) return tree[node];
        if (L <= start && end <= R) return tree[node];
        else {
            int mid = (start + end) >> 1;
            int left = node * 2 + 1;
            int right = node * 2 + 2;
            int ls = query(L, R, left, start, mid);
            int rs = query(L, R, right, mid + 1, end);
            return ls + rs;
        }
    }

    public NumArray1(int[] nums) {
        n = nums.length;
        if (n == 0) return;
        this.nums = nums;
        tree = new int[n * 4];
        buildTree(0, 0, n - 1);
    }

    public void update(int i, int val) {
        updateTree(i, 0, val, 0, n - 1);
    }

    public int sumRange(int i, int j) {
        return query(i, j, 0, 0, n - 1);
    }
}