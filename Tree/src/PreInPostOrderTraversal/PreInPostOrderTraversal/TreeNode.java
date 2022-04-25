package PreInPostOrderTraversal.PreInPostOrderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/25 15:19
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
    /**
     * 前序遍历的非递归（迭代）实现
     *
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //一直往左走
            while (root != null) {
                //前序遍历，可以直接将根节点的值加入序列
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //该右子树了
            root = root.right;
        }
        return list;
    }

    /**
     * 中序遍历的非递归（迭代）实现
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //一直往左走
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //中序遍历，可以将根节点的值加入序列了
            list.add(root.val);
            //该右子树了
            root = root.right;
        }
        return list;
    }

    /**
     * 后序遍历的非递归（迭代）实现
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //前一个节点的指针
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //一直往左走
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //如果没有右子树，或者前一个节点是自己的右子树（说明右子树遍历过了）
            if (root.right == null || prev == root.right) {
                //可以加入序列
                list.add(root.val);
                //更新prev
                prev = root;
                root = null;
            } else {
                //右子树没有被遍历，根你给我回去
                stack.push(root);
                //先去处理右子树
                root = root.right;
            }
        }
        return list;
    }
}


