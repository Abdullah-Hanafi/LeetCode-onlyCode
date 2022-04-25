package Exercise.No236_LowestCommonAncestorOfABinaryTree;

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

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * ˼·
 * 1.������ڵ�root�ǿգ�����ڵ���p��q�ڵ������һ������ô����ֱ�ӷ��ظ��ڵ�root��
 * 2.�ݹ���ã�����������Ѱ������������ڵ�left
 * 3.�ݹ���ã�����������Ѱ������������ڵ�right
 * 4.�ж�һ��left��right�����Ϊ�գ�˵�����������������о���p��q������������ڵ㣬ֱ�ӷ���null
 * 5.�ж϶���leftΪ�գ�����right��rightΪ�գ�����left��
 * 6.�ж�����left��right����Ϊ�գ�ֱ�ӷ���root
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}