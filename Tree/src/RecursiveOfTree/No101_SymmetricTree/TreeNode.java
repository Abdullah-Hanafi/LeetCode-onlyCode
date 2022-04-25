package RecursiveOfTree.No101_SymmetricTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/19 9:52
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


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 整体思路：等价于判断左右树是否对称
 * 1.如果两个子树均为空，则返回true
 * 2.如果两个子树只有一个为空，则返回false
 * 3.如果两个子树均不空，但是值不同，返回false
 * 4.递归调用判断左子树的L和右子树的R，左子树的R和右子树的L
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
