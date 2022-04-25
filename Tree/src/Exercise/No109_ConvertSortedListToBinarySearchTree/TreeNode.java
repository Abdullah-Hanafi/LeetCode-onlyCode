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
 * ˼·��
 * 1.���ҵ�������м�ڵ�
 * 2.�ݹ������������
 * 3.�ݹ������������
 * 4.���ظ��ڵ�
 *
 * ����������Ѱ��������м�ڵ㣨����ҿ�Ѱ���м�ڵ㣩
 * 1.fast��fast.next��������β�ڵ��ʱ��ָ������ƶ�
 * 2.����ֱ�ӷ���slow
 *
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    //[legt,right)����ҿ����Բ��ö�λ�м�ڵ��ǰ�ڵ�
    public TreeNode helper(ListNode left, ListNode right) {
        //��Ϊ������ҿ������Ե�left==right��ʱ��������ʵΪ��
        if (left == right) {
            return null;
        }

        //��ȡ�м�ڵ�Ϊ���ڵ�
        ListNode mid = searchMid(left, right);
        TreeNode root = new TreeNode(mid.val);

        //�ݹ�����������
        root.left = helper(left, mid);

        //�ݹ�����������
        root.right = helper(mid.next, right);

        //���ظ��ڵ�
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