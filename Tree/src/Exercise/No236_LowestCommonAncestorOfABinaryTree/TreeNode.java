package Exercise.No236_LowestCommonAncestorOfABinaryTree;

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

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 思路
 * 1.如果根节点root是空，或根节点是p和q节点的其中一个，那么可以直接返回根节点root；
 * 2.递归调用，在左子树中寻找最近公共父节点left
 * 3.递归调用，在右子树中寻找最近公共父节点right
 * 4.判断一：left和right结果均为空，说明左子树和右子树中均无p和q的最近公共父节点，直接返回null
 * 5.判断二：left为空，返回right；right为空，返回left；
 * 6.判断三：left和right均不为空，直接返回root
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}