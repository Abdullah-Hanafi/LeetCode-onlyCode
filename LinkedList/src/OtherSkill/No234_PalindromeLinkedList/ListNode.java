package OtherSkill.No234_PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/2 9:21
 * ����˼·��
 * 1.��Ѱ���ص㣨�м�ƫ��
 * 2.��ת��벿������
 * 3.����벿��������ǰ�벿��������жԱ�
 */

class Solution {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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