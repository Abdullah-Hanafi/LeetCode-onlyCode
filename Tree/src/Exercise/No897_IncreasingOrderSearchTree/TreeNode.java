package Exercise.No897_IncreasingOrderSearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/25 21:50
 */
public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    TreeNode dummy = new TreeNode(-1);
    TreeNode head = dummy;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return dummy.right;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        head.right = root;
        root.left = null;
        head = head.right;
        helper(root.right);
        return;
    }
}