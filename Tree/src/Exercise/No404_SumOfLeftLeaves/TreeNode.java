package Exercise.No404_SumOfLeftLeaves;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 1.写一个辅助函数，传入参数为根节点和该节点是否为一个左节点的flag
 * ①如果该节点是空节点，则直接返回0
 * ②如果该节点没有左右子节点，并且flag是true，则返回该节点的值
 * 2.主函数直接调用即可
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }


    /**
     * @param root 根节点
     * @param flag 该根节点是否为其父亲的左节点
     * @return
     */
    private int helper(TreeNode root, boolean flag) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && flag) return root.val;
        return helper(root.left, true) + helper(root.right, false);
    }
}


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
