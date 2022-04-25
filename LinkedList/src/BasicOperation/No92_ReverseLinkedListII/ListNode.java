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

        //��һ������prev�ڵ�
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        //��λ��ڵ�
        ListNode leftNode = prev.next;

        //��Ѱ���ҽڵ�
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //��λsucc�ڵ�
        ListNode succ = rightNode.next;

        //�������ж�
        rightNode.next = null;

        //��ת����
        reverseLinkedList(leftNode);

        //ƴ��
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