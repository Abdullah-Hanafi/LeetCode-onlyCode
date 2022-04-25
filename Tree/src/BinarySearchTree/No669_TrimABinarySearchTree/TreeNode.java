package BinarySearchTree.No669_TrimABinarySearchTree;

import sun.reflect.generics.tree.Tree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/23 15:49
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
 * 整体思路：同1110
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        return helper(root, low, high);
    }

    public TreeNode helper(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left, low, high);
        root.right = helper(root.right, low, high);
        int val = root.val;
        if (val > high) {
            return root.left;
        }
        if (val < low) {
            return root.right;
        }
        return root;
    }
}