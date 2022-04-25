package PreInPostOrderTraversal.No105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/22 9:25
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
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }

        //寻找根节点在中序遍历序列中的位置
        int rootPos = indexMap.get(preorder[preBegin]);

        //左子树的节点个数
        int numOfLTree = rootPos - inBegin;

        //创建根节点
        TreeNode root = new TreeNode(preorder[preBegin]);

        root.left = myBuildTree(preorder, inorder, preBegin + 1, preBegin + numOfLTree, inBegin, rootPos - 1);
        root.right = myBuildTree(preorder, inorder, preBegin + numOfLTree + 1, preEnd, rootPos + 1, inEnd);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = inorder.length;
        indexMap = new HashMap<>();

        for (int i = 0; i < l; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, l - 1, 0, l - 1);
    }
}
