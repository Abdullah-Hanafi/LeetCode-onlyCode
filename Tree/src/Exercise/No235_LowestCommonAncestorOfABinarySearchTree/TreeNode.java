package Exercise.No235_LowestCommonAncestorOfABinarySearchTree;


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * ���ն���������������˳����б�������
 * 1.��¼��ǰ�ڵ�Ϊanswer
 * 2.���p��q����answerС����ôanswer��ֵΪ��ڵ�,��ʹ����ȱ���
 * 3.���p��q����answer����ôanswer��ֵΪ�ҽڵ�,��ʹ����ȱ���
 * 4.��֮���ýڵ㼴Ϊ����ڵ�
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