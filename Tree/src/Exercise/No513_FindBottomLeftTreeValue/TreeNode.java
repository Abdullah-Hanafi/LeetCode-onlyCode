package Exercise.No513_FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 层序遍历，遍历到最后一层的时候，把最左边的节点返回即可
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int answer = -1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) answer = queue.peek().val;
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
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