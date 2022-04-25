package Exercise.No572_SubtreeOfAnotherTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 整体思路：
 * 1.先写一个辅助函数，该辅助函数用于判断两棵树是否相等
 * 2.一颗树是另一棵树的子树等价于一颗树与该树相等||一颗树是的左子树的子树||一棵树是该树的右子树的子树
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    /**
     * 判断两棵树是否相等
     * 1.两颗树都是null，则两棵树相等
     * 2.两棵树其中一个为null，则两棵树必然不相等
     * 3.两棵树的对应节点的val不相等，两棵树必然不相等
     * 4.递归进行判断
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
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