package OtherSkill.No160_IntersectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/16 20:56
 */


/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/2 9:21
 * 整体思路：
 * 1.先求两个链表的长度
 * 2.长度长的链表先走使得剩余长度等于另外一个链表的长度
 * 3.循环，直至找到两个相同的节点，否则到链表的结尾退出
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);

        if (lengthA > lengthB) {
            while (lengthA - lengthB > 0) {
                headA = headA.next;
                lengthA--;
            }
        }

        if (lengthB > lengthA) {
            while (lengthB - lengthA > 0) {
                headB = headB.next;
                lengthB--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int length(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}