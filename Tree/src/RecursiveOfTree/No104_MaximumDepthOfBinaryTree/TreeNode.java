package RecursiveOfTree.No104_MaximumDepthOfBinaryTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/18 18:18
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
     * 递归求解树的高度
     */
    public int maxDepth(TreeNode root) {
        //如果树为空
        if (root == null) {
            return 0;
        } else {
            //左子树的高度
            int leftDepth = maxDepth(root.left);
            //右子树的高度
            int rightDepth = maxDepth(root.right);
            //树的高度，得加上根节点
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
