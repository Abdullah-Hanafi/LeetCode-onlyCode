package No876_������м���;

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
     * ż�����ڵ㷵�ص����м��һ��
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
     * ż�����ڵ㷵�ص����м�ڶ���
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
