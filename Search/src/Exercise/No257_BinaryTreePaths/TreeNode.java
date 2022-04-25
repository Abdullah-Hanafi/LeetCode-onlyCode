package Exercise.No257_BinaryTreePaths;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/20 11:11
 */
public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        backtracking(root, "", paths);
        return paths;
    }

    public void backtracking(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }

        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
        }

        if (root.left != null) {
            backtracking(root.left, path + "->", paths);

        }

        if (root.right != null) {
            backtracking(root.right, path + "->", paths);
        }
    }

}
