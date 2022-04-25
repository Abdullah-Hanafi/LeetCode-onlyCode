package PreInPostOrderTraversal.No145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/22 17:50
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
    List<Integer> list = new ArrayList<Integer>();

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        list.add(root.val);
        return list;
    }

    /**
     * @author Cheng Shuaihu
     * @version 1.0
     * @date 2022/1/6 9:44
     * 整体思路：
     * 如果root不为空，或者栈不为空，那么就说明还有没有被访问的节点。需要对其进行访问
     * 1.无论是前序、中序、后序遍历。首先遍历的都是L，所以不断的往二叉树的↙深入
     * 2.到最左下角的时候，我们需要判断这个节点的右子树情况。如果右子树为空或右子树已经遍历过，则可以将最左下角的节点加入队列。
     * 3.问题：如何判断右子树已经遍历过了？设置一个prev指向当前节点的上一个节点即可。初始为null
     */

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //定义栈
        Deque<TreeNode> stack = new LinkedList<>();
        //定义prev节点
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //取出最坐下节点
            root = stack.pop();

            //判断右子树是否被访问或是否为空
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                //重新加入栈中
                stack.push(root);
                //遍历右子树
                root = root.right;
            }
        }
        return list;
    }
}

