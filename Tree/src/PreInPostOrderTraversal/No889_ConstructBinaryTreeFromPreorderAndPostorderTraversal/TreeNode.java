package PreInPostOrderTraversal.No889_ConstructBinaryTreeFromPreorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 1.辅助函数
 * ①创建根节点，preBegin
 * ②在后序遍历序列中寻找左子树根节点的位置
 * ③划分左子树和右子树区间
 * ④递归调用生成二叉树
 * 2.主函数中
 * ①创建map，建立postorder和下标之间的对应关系
 * ②调用辅助函数
 * ③返回根节点
 */

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int l = postorder.length;
        for (int i = 0; i < l; i++) {
            map.put(postorder[i], i);
        }
        return helper(preorder, postorder, 0, l - 1, 0, l - 1);
    }


    public TreeNode helper(int[] preorder, int[] postorder, int preBegin, int preEnd, int postBegin, int postEnd) {
        //递归出口
        if (preBegin > preEnd) {
            return null;
        }

        //创建根节点
        TreeNode root = new TreeNode(preorder[preBegin]);

        if (preBegin == preEnd) return root;
        //在后序遍历序列中寻找左子树根节点的位置
        int lRootPos = map.get(preorder[preBegin + 1]);

        //左子树的长度
        int lLength = lRootPos - postBegin + 1;

        root.left = helper(preorder, postorder, preBegin + 1, preBegin + lLength, postBegin, lRootPos);
        root.right = helper(preorder, postorder, preBegin + lLength + 1, preEnd, lRootPos + 1, postEnd - 1);
        return root;
    }
}

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
