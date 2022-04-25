import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/11 14:06
 */
public class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private DoubleList cache;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int val = node.value;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            //将原先的缓存删除
            cache.remove(map.get(key));
            //更新map
            map.put(key, node);
            //将访问的缓存提前，表示被最新访问
            cache.addFirst(node);
        } else {
            if (capacity == cache.getSize()) {
                Node last = cache.removeLast();
                map.remove(last.key);
                cache.addFirst(node);
                map.put(key, node);
            } else {
                cache.addFirst(node);
                map.put(key, node);
            }
        }
    }
}

class Node {
    public int key;
    public int value;
    public Node prev;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleList {
    public Node head;
    public Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    //插入操作
    public void addFirst(Node node) {
        //当前双链表为空
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }
        size++;
    }

    //删除操作
    public void remove(Node node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (head == node) {
            head = head.next;
            head.prev = null;
        } else if (tail == node) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node = null;
        }
        size--;
    }

    //删除最后一个节点
    public Node removeLast() {
        Node node = tail;
        remove(tail);
        return node;
    }
}
