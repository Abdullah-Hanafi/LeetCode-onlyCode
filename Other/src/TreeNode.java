import java.util.*;

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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    }
}


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 思路
 * 1.递归出口，root==null，直接返回
 * 2.如果root.val > key，递归删除左子树
 * 3.如果root.val < key，递归删除右子树
 * 4.如果root.val == key，分为如下三种情况
 * ①若左子树为空，则右孩子直接替代被删除节点
 * ②若右子树为空，则左孩子直接替代被删除节点
 * ③若左右子树均不为空，找到右子树的最左节点，将左子树变为最左节点的左孩子，而后将右孩子替代被删除节点。
 */

//class Solution {
//    public TreeNode deleteNode(TreeNode root, int key) {
//        //递归出口，root==null，直接返回
//        if (root == null) return null;
//
//        if (root.val > key) {
//            root.left = deleteNode(root.left, key);
//        } else if (root.val < key) {
//            root.right = deleteNode(root.right, key);
//        } else {
//            if (root.left == null) return root.right;
//            if (root.right == null) return root.left;
//            TreeNode node = root.right;
//            while (node.left != null) {
//                node = node.left;
//            }
//            node.left = root.left;
//            root = root.right;
//        }
//
//        return root;
//    }
//
//}