package No2_两数相加;


 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + carry;
            if(val >= 10){
                val = val - 10;
                carry = 1;
            }else{
                carry = 0;
            }

            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int val = l1.val + carry;
            if(val >= 10){
                val = val - 10;
                carry = 1;
            }else{
                carry = 0;
            }

            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int val = l2.val + carry;
            if(val >= 10){
                val = val - 10;
                carry = 1;
            }else{
                carry = 0;
            }

            current.next = new ListNode(val);
            current = current.next;
            l2 = l2.next;
        }

        if(carry == 1){
            current.next = new ListNode(1);
            current = current.next;
        }

        return head.next;
    }
}