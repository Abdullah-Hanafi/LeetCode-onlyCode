package PreInPostOrderTraversal.No144_BinaryTreePreorderTraversal;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/22 17:25
 */
public class TreeNode {
    int val;
    TreeNode left, right;

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
    private List<Integer> list = new ArrayList<>();

    /**
     * 递归形式实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }

        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return list;
    }

    /**
     * 非递归形式实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //一直往左压入栈
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;

        }
        return list;
    }

}
