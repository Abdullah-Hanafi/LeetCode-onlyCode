package PreInPostOrderTraversal.No145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/22 17:50
 */
public class TreeNode {
    int val;
    TreeNode left, right;

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
    List<Integer> list = new ArrayList<Integer>();

    /**
     * �ݹ�ʵ��
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        list.add(root.val);
        return list;
    }

    /**
     * @author Cheng Shuaihu
     * @version 1.0
     * @date 2022/1/6 9:44
     * ����˼·��
     * ���root��Ϊ�գ�����ջ��Ϊ�գ���ô��˵������û�б����ʵĽڵ㡣��Ҫ������з���
     * 1.������ǰ�����򡢺�����������ȱ����Ķ���L�����Բ��ϵ����������ĨL����
     * 2.�������½ǵ�ʱ��������Ҫ�ж�����ڵ����������������������Ϊ�ջ��������Ѿ�������������Խ������½ǵĽڵ������С�
     * 3.���⣺����ж��������Ѿ��������ˣ�����һ��prevָ��ǰ�ڵ����һ���ڵ㼴�ɡ���ʼΪnull
     */

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //����ջ
        Deque<TreeNode> stack = new LinkedList<>();
        //����prev�ڵ�
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //ȡ�������½ڵ�
            root = stack.pop();

            //�ж��������Ƿ񱻷��ʻ��Ƿ�Ϊ��
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                //���¼���ջ��
                stack.push(root);
                //����������
                root = root.right;
            }
        }
        return list;
    }
}

