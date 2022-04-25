package BasicOperation.No92_ReverseLinkedListII;

import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/13 11:48
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //第一步先找prev节点
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        //定位左节点
        ListNode leftNode = prev.next;

        //在寻找右节点
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //定位succ节点
        ListNode succ = rightNode.next;

        //将链表切断
        rightNode.next = null;

        //反转链表
        reverseLinkedList(leftNode);

        //拼接
        prev.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;
    }


    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}