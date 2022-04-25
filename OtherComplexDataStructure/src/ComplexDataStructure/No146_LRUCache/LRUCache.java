package ComplexDataStructure.No146_LRUCache;

import java.util.HashMap;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/29 9:32
 */

/**
 * 题解中的一个思路
 */
public class LRUCache {
    //记录数据,key->(key,node)
    private HashMap<Integer, Node> map;
    //记录内存访问顺序
    private DoubleList cache;
    //记录cash大小
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        //key被访问了，所以需要在cache中提前
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            map.put(key, x);
            cache.addFirst(x);
        } else {
            if (capacity == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

//双链表的节点类
class Node {
    public int key, val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//依靠Node类型构造一个双链表
class DoubleList {
    //表头指针
    private Node head;

    //表尾指针
    private Node tail;

    //表长
    private int size;

    //在双链表头部添加节点x，时间是O(1)
    public void addFirst(Node x) {
        //链表为空
        if (head == null) {
            head = x;
            tail = x;
        } else {
            Node current = head;
            current.prev = x;
            x.next = current;
            head = x;
        }
        size++;
    }

    //删除链表中的x节点（x一定存在）
    //由于是双链表且给的是目标Node节点，时间是O(1)
    public void remove(Node x) {
        //如果链表只有一个节点
        //删除节点是头节点
        //删除节点是尾节点
        //删除节点是非头节点，非尾节点
        if (head == x && tail == x) {
            head = null;
            tail = null;
        } else if (head == x) {
            head = head.next;
            head.prev = null;
        } else if (tail == x) {
            tail = tail.prev;
            tail.next = null;
        } else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        size--;
    }

    //删除链表中的最后一个节点，并返回该节点，时间是O(1)
    public Node removeLast() {
        Node node = tail;
        remove(tail);
        return node;
    }

    //返回链表的长度，时间是O(1);
    public int size() {
        return size;
    }
}