package RecursiveOfTree.No543_DiameterOfBinaryTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/18 19:12
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
    //存放直径的最大值，直径为当前节点root的左子树深度+右子树深度
    int answer;

    public int diameterOfBinaryTree(TreeNode root) {
        treeHeight(root);
        return answer;
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int L = treeHeight(root.left);
            int R = treeHeight(root.right);
            //对于不同的root有不同的直径最大值，所以需要更新直径最大值
            answer = Math.max(answer, L + R);
            return Math.max(L, R) + 1;
        }
    }
}