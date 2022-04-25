package ComplexDataStructure.No146_LRUCache;

import java.util.HashMap;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/29 9:32
 */

/**
 * ����е�һ��˼·
 */
public class LRUCache {
    //��¼����,key->(key,node)
    private HashMap<Integer, Node> map;
    //��¼�ڴ����˳��
    private DoubleList cache;
    //��¼cash��С
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        //key�������ˣ�������Ҫ��cache����ǰ
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

//˫����Ľڵ���
class Node {
    public int key, val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//����Node���͹���һ��˫����
class DoubleList {
    //��ͷָ��
    private Node head;

    //��βָ��
    private Node tail;

    //��
    private int size;

    //��˫����ͷ����ӽڵ�x��ʱ����O(1)
    public void addFirst(Node x) {
        //����Ϊ��
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

    //ɾ�������е�x�ڵ㣨xһ�����ڣ�
    //������˫�����Ҹ�����Ŀ��Node�ڵ㣬ʱ����O(1)
    public void remove(Node x) {
        //�������ֻ��һ���ڵ�
        //ɾ���ڵ���ͷ�ڵ�
        //ɾ���ڵ���β�ڵ�
        //ɾ���ڵ��Ƿ�ͷ�ڵ㣬��β�ڵ�
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

    //ɾ�������е����һ���ڵ㣬�����ظýڵ㣬ʱ����O(1)
    public Node removeLast() {
        Node node = tail;
        remove(tail);
        return node;
    }

    //��������ĳ��ȣ�ʱ����O(1);
    public int size() {
        return size;
    }
}