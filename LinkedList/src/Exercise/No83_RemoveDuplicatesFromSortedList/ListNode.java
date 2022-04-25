package Exercise.No83_RemoveDuplicatesFromSortedList;


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/2 9:21
 * ����˼·��
 * 1.����һ��ǰ���ڵ�prev
 * 2.����������ǰ�ڵ������prev��ͬ��ɾ������ͬ�͸���prev
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-101);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (head != null) {
            if (prev.val == head.val) {
                prev.next = head.next;

            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}

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