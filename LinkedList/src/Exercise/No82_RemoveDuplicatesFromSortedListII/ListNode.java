package Exercise.No82_RemoveDuplicatesFromSortedListII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/13 13:15
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode last = dummyNode;
        while (last.next != null && last.next.next != null) {
            if (last.next.val == last.next.next.val) {
                int current = last.next.val;
                while (last.next.val == current) {
                    last.next = last.next.next;
                }
            } else {
                last = last.next;
            }
        }
        return dummyNode.next;
    }

}
