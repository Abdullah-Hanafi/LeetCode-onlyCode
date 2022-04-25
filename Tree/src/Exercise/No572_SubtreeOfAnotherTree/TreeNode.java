package Exercise.No572_SubtreeOfAnotherTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * ����˼·��
 * 1.��дһ�������������ø������������ж��������Ƿ����
 * 2.һ��������һ�����������ȼ���һ������������||һ�����ǵ�������������||һ�����Ǹ�����������������
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    /**
     * �ж��������Ƿ����
     * 1.����������null�������������
     * 2.����������һ��Ϊnull������������Ȼ�����
     * 3.�������Ķ�Ӧ�ڵ��val����ȣ���������Ȼ�����
     * 4.�ݹ�����ж�
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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