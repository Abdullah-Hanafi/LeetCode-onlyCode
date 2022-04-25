package RecursiveOfTree.No1110_DeleteNodesAndReturnForest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * 1.���帨������������ɾ����rootΪ���ڵ������ָ������ֵ��ʣ��Ľڵ�����ɵ�����
 * 1.���rootΪnull����ֱ�ӷ���null
 * 2.�ݹ�ɾ��root.left������root.left
 * 3.�ݹ�ɾ��root.right������root.right
 * 4.�жϸ��ڵ��Ƿ��Ǵ�ɾ��Ԫ�أ�����ǽ����ڵ���Ϊnull���õ��������ֱ�Ϊroot.left��root.right�������֮��
 * 2.�������ȴ���һ���������ڴ洢��ɾ��Ԫ�ؼ��ϣ���������жϽڵ��Ƿ�Ӧ�ñ�ɾ��
 */
class Solution {
    Set<Integer> to_Delete;
    List<TreeNode> answer;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //��ʼ����ɾ���ڵ�
        to_Delete = new HashSet<>();
        for (int i : to_delete) {
            to_Delete.add(i);
        }

        answer = new ArrayList<>();
        //��ԭ�������޼�
        root = helper(root);
        //������ڵ�û�б�ɾ���������ս��Ҫ����ԭ�����޼����
        if (root != null) {
            answer.add(root);
        }
        return answer;
    }


    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        //����������ɾ���ڵ�
        root.left = helper(root.left);
        //����������ɾ���ڵ�
        root.right = helper(root.right);

        //�жϸ��ڵ��Ƿ���Ҫɾ���������Ҫɾ����������������
        int val = root.val;
        if (to_Delete.contains(val)) {
            //���޼����������������
            if (root.left != null) {
                answer.add(root.left);
            }

            //���޼����������������
            if (root.right != null) {
                answer.add(root.right);
            }

            //ɾ�����ڵ�
            root = null;
        }
        return root;
    }
}