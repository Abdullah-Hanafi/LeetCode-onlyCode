package PreInPostOrderTraversal.PreInPostOrderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/25 15:19
 */
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

class Solution {
    /**
     * ǰ������ķǵݹ飨������ʵ��
     *
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //һֱ������
            while (root != null) {
                //ǰ�����������ֱ�ӽ����ڵ��ֵ��������
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //����������
            root = root.right;
        }
        return list;
    }

    /**
     * ��������ķǵݹ飨������ʵ��
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //һֱ������
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //������������Խ����ڵ��ֵ����������
            list.add(root.val);
            //����������
            root = root.right;
        }
        return list;
    }

    /**
     * ��������ķǵݹ飨������ʵ��
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //ǰһ���ڵ��ָ��
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //һֱ������
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //���û��������������ǰһ���ڵ����Լ�����������˵���������������ˣ�
            if (root.right == null || prev == root.right) {
                //���Լ�������
                list.add(root.val);
                //����prev
                prev = root;
                root = null;
            } else {
                //������û�б�������������һ�ȥ
                stack.push(root);
                //��ȥ����������
                root = root.right;
            }
        }
        return list;
    }
}


