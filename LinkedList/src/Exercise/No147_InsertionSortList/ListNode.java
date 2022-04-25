package Exercise.No147_InsertionSortList;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/17 13:38
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
     * 插入排序的思想：将待排序列里的第一个元素插到有序序列中的合适位置
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0, head);
        ListNode lastSorted = head; //链表的已排序部分的最后一个节点
        ListNode current = head.next;   //待插入的元素

        //没有待插入元素的时候退出循环
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
            //更新待插入元素
            current = lastSorted.next;
        }
        return dummyHead.next;
    }
}