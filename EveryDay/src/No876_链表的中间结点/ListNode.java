package No876_链表的中间结点;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/13 14:00
 */
public class ListNode {
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

class Solution {
    /**
     * 偶数个节点返回的是中间第一个
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 偶数个节点返回的是中间第二个
     */
    public ListNode middleNode1(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow;
    }
}
