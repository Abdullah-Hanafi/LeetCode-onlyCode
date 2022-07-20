//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 840 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //1.建立inorder的map，key为节点值，value为节点在inorder中的下标，方便找根节点在inorder中的位置
        for (int i = 0; i < inorder.length; i++) {
            pos.put(inorder[i], i);
        }
        TreeNode root = helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    //构造树的辅助函数
    public TreeNode helper(int[] preorder, int pBegin, int pEnd, int[] inorder, int iBegin, int iEnd) {
        //递归出口
        if (pBegin > pEnd) {
            return null;
        }
        int position = pos.get(preorder[pBegin]);
        TreeNode root = new TreeNode(preorder[pBegin]);
        root.left = helper(preorder, pBegin + 1, pBegin + position - iBegin, inorder, iBegin, position - 1);
        root.right = helper(preorder, pBegin + position - iBegin+1, pEnd, inorder, position + 1, iEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
