package Exercise.No404_SumOfLeftLeaves;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 1.дһ�������������������Ϊ���ڵ�͸ýڵ��Ƿ�Ϊһ����ڵ��flag
 * ������ýڵ��ǿսڵ㣬��ֱ�ӷ���0
 * ������ýڵ�û�������ӽڵ㣬����flag��true���򷵻ظýڵ��ֵ
 * 2.������ֱ�ӵ��ü���
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }


    /**
     * @param root ���ڵ�
     * @param flag �ø��ڵ��Ƿ�Ϊ�丸�׵���ڵ�
     * @return
     */
    private int helper(TreeNode root, boolean flag) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && flag) return root.val;
        return helper(root.left, true) + helper(root.right, false);
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
