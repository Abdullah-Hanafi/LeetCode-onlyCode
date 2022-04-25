package PriorityQueue.No23_MergeKSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(12);
        priorityQueue.add(8);
        priorityQueue.add(18);
        System.out.println(priorityQueue.remove());

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode currentHead = lists[i];
            while (currentHead != null) {
                priorityQueue.add(new ListNode(currentHead.val));
                currentHead = currentHead.next;
            }
        }

        if (priorityQueue.isEmpty()) {
            return null;
        }
        ListNode head = priorityQueue.remove();
        ListNode current = head;
        while (!priorityQueue.isEmpty()) {
            current.next = priorityQueue.remove();
            current = current.next;
        }
        return head;
    }
}
