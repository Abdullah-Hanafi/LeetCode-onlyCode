package PreInPostOrderTraversal.No889_ConstructBinaryTreeFromPreorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 1.��������
 * �ٴ������ڵ㣬preBegin
 * ���ں������������Ѱ�����������ڵ��λ��
 * �ۻ���������������������
 * �ܵݹ�������ɶ�����
 * 2.��������
 * �ٴ���map������postorder���±�֮��Ķ�Ӧ��ϵ
 * �ڵ��ø�������
 * �۷��ظ��ڵ�
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
        //�ݹ����
        if (preBegin > preEnd) {
            return null;
        }

        //�������ڵ�
        TreeNode root = new TreeNode(preorder[preBegin]);

        if (preBegin == preEnd) return root;
        //�ں������������Ѱ�����������ڵ��λ��
        int lRootPos = map.get(preorder[preBegin + 1]);

        //�������ĳ���
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
