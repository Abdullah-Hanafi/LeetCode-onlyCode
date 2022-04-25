package RandomAndSampling.No382_LinkedListRandomNode;

class Solution {
    private ListNode head;
    private int number;

    public Solution(ListNode head) {
        this.head = head;
        this.number = head.val;
    }

    public int getRandom() {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;

            int count = (int) (Math.random() * length + 1);
            if (count == length) {
                number = current.val;
            }
            current = current.next;
        }
        return number;
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