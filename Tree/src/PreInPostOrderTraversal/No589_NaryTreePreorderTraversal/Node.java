package PreInPostOrderTraversal.No589_NaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/22 21:52
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
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null) {
            return list;
        }
        list.add(root.val);

        for (Node child : root.children) {
            preorder(child);
        }

        return list;
    }
}
