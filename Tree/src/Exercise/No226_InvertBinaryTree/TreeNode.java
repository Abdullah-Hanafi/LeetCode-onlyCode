package Exercise.No226_InvertBinaryTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/24 16:11
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode L = root.left;
        TreeNode R = root.right;
        root.left = invertTree(R);
        root.right = invertTree(L);
        return root;
    }
}