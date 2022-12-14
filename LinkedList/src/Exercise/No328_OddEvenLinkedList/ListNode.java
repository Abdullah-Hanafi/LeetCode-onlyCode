package Exercise.No328_OddEvenLinkedList;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;    //用于移动的奇数表指针
        ListNode even = head.next;  //用于移动的偶数表指针
        ListNode evenHead = head.next;  //指向偶数表

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
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