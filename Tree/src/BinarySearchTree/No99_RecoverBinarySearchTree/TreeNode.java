package BinarySearchTree.No99_RecoverBinarySearchTree;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/23 16:24
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
     * 暴力实现,O(n)的空间复杂度
     */
    List<Integer> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        inorder(root);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        recoverTreeHelper(root);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public void recoverTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTreeHelper(root.left);
        root.val = list.remove(0);
        recoverTreeHelper(root.right);
    }


    /**
     * O(1)空间复杂度，以下方法有问题
     */

    public void recoverTree1(TreeNode root) {
        TreeNode mistake1 = null;
        TreeNode mistake2 = null;
        TreeNode prev = null;
        recoverTreeHelper1(root, mistake1, mistake2, prev);
        if (mistake1 != null && mistake2 != null) {
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }

    }

    public void recoverTreeHelper1(TreeNode root, TreeNode mistake1, TreeNode mistake2, TreeNode prev) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            recoverTreeHelper1(root.left, mistake1, mistake2, prev);
        }

        if (prev != null && root.val < prev.val) {
            if (mistake1 == null) {
                mistake1 = prev;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        prev = root;
        if (root.right != null) {
            recoverTreeHelper1(root.right, mistake1, mistake2, prev);
        }

    }
}
