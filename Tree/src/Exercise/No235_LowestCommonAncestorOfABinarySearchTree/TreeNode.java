package Exercise.No235_LowestCommonAncestorOfABinarySearchTree;


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 按照二叉搜索树的搜索顺序进行遍历即可
 * 1.记录当前节点为answer
 * 2.如果p和q都比answer小，那么answer赋值为左节点,以使得深度变深
 * 3.如果p和q都比answer大，那么answer赋值为右节点,以使得深度变深
 * 4.反之，该节点即为所求节点
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode answer = root;
        while (true) {
            if (p.val < answer.val && q.val < answer.val) {
                answer = answer.left;
            } else if (p.val > answer.val && q.val > answer.val) {
                answer = answer.right;
            } else {
                break;
            }
        }
        return answer;
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