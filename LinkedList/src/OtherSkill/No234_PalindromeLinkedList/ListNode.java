package OtherSkill.No234_PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/2 9:21
 * 整体思路：
 * 1.先寻找重点（中间偏左）
 * 2.反转后半部分链表
 * 3.将后半部分链表与前半部分链表进行对比
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