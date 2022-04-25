package RecursiveOfTree.No559_MaximumDepthOfNaryTree;

import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/22 22:32
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth + 1;

    }
}