package PreInPostOrderTraversal.No106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/23 9:18
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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, l - 1, 0, l - 1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inBegin, int inEnd, int postBegin, int postEnd) {
        if (postBegin > postEnd) {
            return null;
        }

        //获取根节点在中序遍历中的位置
        int rootPos = map.get(postorder[postEnd]);
        //获取左子树的长度
        int numOfLTree = rootPos - inBegin;
        //创建根节点
        TreeNode node = new TreeNode(postorder[postEnd]);
        node.left = buildTreeHelper(inorder, postorder, inBegin, rootPos - 1, postBegin, postBegin + numOfLTree - 1);
        node.right = buildTreeHelper(inorder, postorder, rootPos + 1, inEnd, postBegin + numOfLTree, postEnd - 1);
        return node;
    }
}