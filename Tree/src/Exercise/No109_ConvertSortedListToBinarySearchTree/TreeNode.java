package Exercise.No109_ConvertSortedListToBinarySearchTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/25 21:14
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

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/1/6 9:44
 * 思路：
 * 1.先找到链表的中间节点
 * 2.递归的生成左子树
 * 3.递归的生成右子树
 * 4.返回根节点
 *
 * 辅助函数：寻找链表的中间节点（左闭右开寻找中间节点）
 * 1.fast且fast.next不是链表尾节点的时候指针进行移动
 * 2.否则直接返回slow
 *
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    //[legt,right)左闭右开可以不用定位中间节点的前节点
    public TreeNode helper(ListNode left, ListNode right) {
        //因为是左闭右开，所以当left==right的时候，链表其实为空
        if (left == right) {
            return null;
        }

        //获取中间节点为根节点
        ListNode mid = searchMid(left, right);
        TreeNode root = new TreeNode(mid.val);

        //递归生成左子树
        root.left = helper(left, mid);

        //递归生成右子树
        root.right = helper(mid.next, right);

        //返回根节点
        return root;
    }

    private ListNode searchMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}