package BreadthFirstSearch.No116_PopulationgNextRightPointersInEachNode;

import BreadthFirstSearch.No112_LuJingZongHe.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/2 10:46
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {

    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == 0) {
                    prev = node;
                    prev.next = null;
                } else {
                    prev.next = node;
                    prev = node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}