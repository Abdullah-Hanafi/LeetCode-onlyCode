package RecursiveOfTree.No110_BalancedBinaryTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/18 18:31
 */
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
    /**
     * 左右子树的高度差的绝对值小于等于1，且左右子树都是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
