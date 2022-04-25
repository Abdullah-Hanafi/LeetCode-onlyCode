package BreadthFirstSearch.No112_LuJingZongHe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/2 10:03
 */
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

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        //��¼�ڵ�
        Queue<TreeNode> queue = new LinkedList<>();
        //��¼���ﵱǰ�ڵ��·����
        Queue<Integer> pathSum = new LinkedList<>();
        queue.offer(root);
        pathSum.offer(root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int temp = pathSum.poll();

            //������ڵ���
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
                //������һ�ֵ���
                continue;
            }

            if (node.left != null) {
                queue.offer(node.left);
                pathSum.offer(node.left.val + temp);
            }

            if (node.right != null) {
                queue.offer(node.right);
                pathSum.offer(node.right.val + temp);
            }
        }
        return false;
    }
}
