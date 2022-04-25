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
 * ����˼·��
 * 1.������������ĳ���
 * 2.���ȳ�����������ʹ��ʣ�೤�ȵ�������һ������ĳ���
 * 3.ѭ����ֱ���ҵ�������ͬ�Ľڵ㣬��������Ľ�β�˳�
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