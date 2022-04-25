package No_783二叉搜索树节点最小距离;

import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        InOrder(root);
        for (int i = 0; i < list.size() - 1; i++)
            min = Math.min(min, list.get(i + 1) - list.get(i));

        return min;
    }

    public void InOrder(TreeNode root) {
        if (root == null) return;
        InOrder(root.left);
        list.add(root.val);
        InOrder(root.right);
    }
}