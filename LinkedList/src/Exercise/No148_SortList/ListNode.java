package Exercise.No148_SortList;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/17 11:45
 */
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

class Solution {
    /**
     * 插入排序,同147，但是时间复杂度没达到要求
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        //有序序列最后一个元素
        ListNode lastSorted = head;

        //当前待排序列的第一个元素
        ListNode current = head.next;

        //当还有待排元素的时候
        while (current != null) {
            if (lastSorted.val <= current.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode previous = dummyHead;
                while (previous.next.val <= current.val) {
                    previous = previous.next;
                }
                lastSorted.next = current.next;
                current.next = previous.next;
                previous.next = current;
            }
            current = lastSorted.next;
        }
        return dummyHead.next;
    }


    /**
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        return null;
    }
}