package RecursiveOfTree.No437_PathSumIII;

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
 * 整体思路：
 * 1.计算每个节点为根时，以该节点为起点路径和为目标值的路径数目。
 * 2.树中符合条件的总路径数应该为根节点的1中所求与左子树符合条件的总路径数和右子树符合条件的总路径数
 */
class Solution {

    //树中符合条件的总路径数应该为根节点的1中所求与左子树符合条件的总路径数和右子树符合条件的总路径数
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    //计算每个节点为根时，以该节点为起点路径和为目标值的路径数目。
    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }

        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}