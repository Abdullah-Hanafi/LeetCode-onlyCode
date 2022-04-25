package Exercise.No432_AllOoneDataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/28 23:10
 */
public class AnswerAllOne {
    /**
     * k-v���ҽڵ�
     */
    private final Map<String, ListNode> map = new HashMap<>();
    /**
     * key - �ڵ��ֵ��
     * value - �����е�һ��ֵΪkey�Ľڵ㡣
     */
    private final Map<Integer, ListNode> first = new HashMap<>();
    /**
     * key - �ڵ��ֵ��
     * value - ���������һ��ֵΪkey�Ľڵ㡣
     */
    private final Map<Integer, ListNode> last = new HashMap<>();

    /**
     * ����αͷ�ڵ�
     */
    private final ListNode head = new ListNode(null, 0);
    /**
     * ����αβ�ڵ�
     */
    private final ListNode tail = new ListNode(null, 0);

    AnswerAllOne() {
        head.next = tail;
        tail.prev = head;
    }

    private class ListNode { // ����ڵ�
        ListNode prev, next;
        String key;
        int val;

        public ListNode(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * ���ڵ� [insert] ���뵽 n1 �� n2 ֮��
     */
    private void insert(ListNode n1, ListNode n2, ListNode insert) {
        n1.next = insert;
        n2.prev = insert;
        insert.prev = n1;
        insert.next = n2;
    }

    /**
     * ɾ������ڵ�[n]
     */
    private void remove(ListNode n) {
        ListNode prev = n.prev;
        ListNode next = n.next;
        prev.next = next;
        next.prev = prev;
        n.prev = null;
        n.next = null;
    }

    /**
     * ���ڵ�node�ƶ���prev��next֮��
     */
    private void move(ListNode node, ListNode prev, ListNode next) {
        remove(node);
        insert(prev, next, node);
    }

    /**
     * ��[node]����Ϊ�µ�valֵ��ʼ��
     */
    private void newFirst(int val, ListNode node) {
        first.put(val, node);
        if (!last.containsKey(val)) last.put(val, node);
    }

    /**
     * ��[node]����Ϊ�µ�valֵ��ֹ��
     */
    private void newLast(int val, ListNode node) {
        last.put(val, node);
        if (!first.containsKey(val)) first.put(val, node);
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     * <p>
     * ֵ��һ�󣬵�ǰ�ڵ�������ƶ���
     * �����ǰkey�����ڣ��ǾͰ�����ڵ���뵽����β��.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) { // ��ǰkey�����ڣ����뵽����ĩβ
            ListNode node = new ListNode(key, 1);
            map.put(key, node);
            insert(tail.prev, tail, node); // ����
            if (!first.containsKey(1)) newFirst(1, node); // ����first
            newLast(1, node); // ����last
        } else {
            ListNode node = map.get(key); // ��ǰ�ڵ�
            int val = node.val; // ��ֵ
            int newVal = val + 1; // ��ֵ
            ListNode firstNode = first.get(val); // �����е�һ��ֵΪval�Ľڵ�
            ListNode lastNode = last.get(val); // ���������һ��ֵΪval�Ľڵ�

            // 1. ��λ��
            node.val = newVal;
            if (firstNode == lastNode) { // ��ǰ�ڵ���Ψһһ��ֵΪval�Ľڵ�
                first.remove(val); // û��ֵΪval�Ľڵ���
                last.remove(val); // û��ֵΪval�Ľڵ���
                newLast(newVal, node); // ����last
            } else if (node == firstNode) { // �ýڵ��������е�һ��ֵΪval�Ľڵ�
                // ����
                newLast(newVal, node);
                newFirst(val, node.next);
            } else {
                if (node == lastNode) newLast(val, node.prev); // �����һ��ֵval�Ľڵ�
                // ���ʱ�򣬽ڵ�Ӧ���ƶ��������е�һ��ֵΪval�Ľڵ�֮ǰ
                move(node, firstNode.prev, firstNode);
                newLast(newVal, node);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     * <p>
     * ֵ��һ֮�󣬽ڵ��������е�λ�û������ƶ�
     */
    public void dec(String key) {
        // ��inc���ƣ���������һ��ֵΪ1ɾ�����ж�
        ListNode node = map.get(key);
        if (node == null) return;

        int val = node.val;
        int newVal = val - 1;
        ListNode firstNode = first.get(val);
        ListNode lastNode = last.get(val);

        if (val == 1) { // ֵΪ1��ɾ������ڵ�
            if (firstNode == lastNode) { // û��ֵΪ1�Ľڵ���
                first.remove(1);
                last.remove(1);
            } else if (node == firstNode) { // ��ʼֵ����
                first.put(1, node.next);
            } else if (node == lastNode) { // �ս�ֵ����
                last.put(1, node.prev);
            }
            remove(node);
            map.remove(key);
        } else {
            node.val = newVal;
            if (firstNode == lastNode) { // ΨһֵΪval�Ľڵ�
                // λ�ò��䣬��ΪnewVal����λ
                first.remove(val);
                last.remove(val);
                newFirst(newVal, node);
            } else if (node == lastNode) { // �����һ��valֵ�Ľڵ�
                // λ�ò��䣬��ΪnewVal����λ������prev��Ϊval�����һλ
                newFirst(newVal, node);
                newLast(val, node.prev);
            } else {
                if (node == firstNode) newFirst(val, node.next); // �ǵ�һ��valֵ�Ľڵ�
                move(node, lastNode, lastNode.next); // �ƶ���lastNode֮��
                newFirst(newVal, node);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     * ��������ͷ
     */
    public String getMaxKey() {
        return head.next == tail ? "" : head.next.key;
    }

    /**
     * Returns one of the keys with Minimal value.
     * ��������β
     */
    public String getMinKey() {
        return tail.prev == head ? "" : tail.prev.key;
    }
}