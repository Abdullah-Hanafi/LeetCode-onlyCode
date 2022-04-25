package BasicOperation.No206_ReverseLinkedList;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    /**
     * 方法一：非递归方法
     * ①：定义原链表的前节点
     * ②：定义一个next节点用于遍历原链表
     * 进入循环
     * 先将head.next赋值给next，防止为遍历的链表中断
     * 再将prev赋值给head.next，即原链表的前节点，变成反转链表的后节点
     * 再将head赋值给prev，即更新前节点，为下一轮循环做准备
     * 最后将next赋值给head，保证链表遍历不会被中断
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //定义原链表的前节点
        ListNode prev = null;
        //定义用于防止遍历中断的中间变量
        ListNode next;
        while (head != null) {
            //先保存待遍历的剩余链表
            next = head.next;
            //当前节点的下一个节点即为原链表的前一个节点
            head.next = prev;
            //当前节点为下一轮循环的前一个节点
            prev = head;
            //保证原链表的遍历不被中断
            head = next;
        }
        return prev;
    }

    /**
     * 以链表1->2->3->4->5举例
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            /*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        ListNode newHead = reverseList(head.next);
                /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return newHead;
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
