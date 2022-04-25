package Offer_55二叉树的深度;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/26 22:52
 */
public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}


class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}