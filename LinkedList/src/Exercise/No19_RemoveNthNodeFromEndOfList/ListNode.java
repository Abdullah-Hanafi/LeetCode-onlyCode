package Exercise.No19_RemoveNthNodeFromEndOfList;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/2 9:21
 * 整体思路：快慢指针
 * 1.快指针先走n格
 * 2.快指针和慢指针同时开始走
 * 3.删除节点
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode slow = dummy;
        ListNode fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}