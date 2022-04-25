package Exercise.No530_MinimumAbsoluteDifferenceInBST;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/25 11:57
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
    int min = Integer.MAX_VALUE;
    //当前节点的前一个节点的值
    int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return min;
    }

    //中序遍历
    public void inOrderTraversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (prev == -1) {    //第一个节点没有prev,所以prev为其本身
            prev = root.val;
        } else {
            min = Math.min(min, root.val - prev);
            prev = root.val;
        }

        inOrderTraversal(root.right);
    }
}