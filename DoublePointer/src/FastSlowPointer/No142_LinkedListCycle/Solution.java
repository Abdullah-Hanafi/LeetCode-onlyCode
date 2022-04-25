package FastSlowPointer.No142_LinkedListCycle;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    /**
     * 方法一：Floyd判圈法
     * 快慢指针都指向头节点，快指针走两步、慢指针走一步。
     * 如果快指针没走到了链表的尽头，说明无环
     * 如果快指针和指针相遇，说明必定有环。
     * 将快指针指向head节点
     * 快慢指针都一次走一步
     * 相遇时的节点即为环路的第一个节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            //fast可以走到尽头
            if (fast == null || fast.next == null)
                return null;

            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

