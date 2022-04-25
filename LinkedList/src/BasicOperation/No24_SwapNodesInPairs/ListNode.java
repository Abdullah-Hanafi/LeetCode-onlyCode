package BasicOperation.No24_SwapNodesInPairs;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/16 16:53
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode left = temp.next;
            ListNode right = temp.next.next;

            temp.next = right;
            left.next = right.next;
            right.next = left;
            temp = left;
        }
        return dummyNode.next;
    }
}