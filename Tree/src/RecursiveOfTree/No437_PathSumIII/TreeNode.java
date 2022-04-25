package RecursiveOfTree.No437_PathSumIII;

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


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * ����˼·��
 * 1.����ÿ���ڵ�Ϊ��ʱ���Ըýڵ�Ϊ���·����ΪĿ��ֵ��·����Ŀ��
 * 2.���з�����������·����Ӧ��Ϊ���ڵ��1��������������������������·������������������������·����
 */
class Solution {

    //���з�����������·����Ӧ��Ϊ���ڵ��1��������������������������·������������������������·����
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    //����ÿ���ڵ�Ϊ��ʱ���Ըýڵ�Ϊ���·����ΪĿ��ֵ��·����Ŀ��
    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }

        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}