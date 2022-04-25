package RecursiveOfTree.No1110_DeleteNodesAndReturnForest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 整体思路：
 * 1.定义辅助函数：返回删除以root为根节点的树中指定的数值后剩余的节点所组成的树。
 * 1.如果root为null，则直接返回null
 * 2.递归删除root.left并返回root.left
 * 3.递归删除root.right并返回root.right
 * 4.判断根节点是否是待删除元素，如果是将根节点置为null，得到两颗树分别为root.left和root.right并加入答案之中
 * 2.主函数先创建一个集合用于存储待删除元素集合，方便进行判断节点是否应该被删除
 */
class Solution {
    Set<Integer> to_Delete;
    List<TreeNode> answer;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //初始化待删除节点
        to_Delete = new HashSet<>();
        for (int i : to_delete) {
            to_Delete.add(i);
        }

        answer = new ArrayList<>();
        //对原树进行修剪
        root = helper(root);
        //如果根节点没有被删除，则最终结果要加入原树的修剪结果
        if (root != null) {
            answer.add(root);
        }
        return answer;
    }


    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        //左子树进行删除节点
        root.left = helper(root.left);
        //右子树进行删除节点
        root.right = helper(root.right);

        //判断根节点是否需要删除，如果需要删除，加入左右子树
        int val = root.val;
        if (to_Delete.contains(val)) {
            //将修剪过的左子树加入答案
            if (root.left != null) {
                answer.add(root.left);
            }

            //将修剪过的右子树加入答案
            if (root.right != null) {
                answer.add(root.right);
            }

            //删除根节点
            root = null;
        }
        return root;
    }
}