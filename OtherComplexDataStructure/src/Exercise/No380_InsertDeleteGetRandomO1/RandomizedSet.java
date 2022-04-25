package Exercise.No380_InsertDeleteGetRandomO1;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/28 22:27
 */
public class RandomizedSet {
    //存放key是数据，value是索引
    private Map<Integer, Integer> map;

    //存放数据
    private List<Integer> list;
    //随机器
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        //如果hashmap里存有数据的索引，那么返回false
        if (map.containsKey(val)) return false;
        //没有这个数据
        //先记录索引,这样list.size()不用减1
        map.put(val, list.size());
        //插到链表的末尾
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        //没有要删除的数据，直接返回false
        if (!map.containsKey(val)) return false;

        //交换最后一个数据和要删除的数据的位置，然后将链表末尾的元素删除
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        //更新索引信息
        map.put(lastElement, index);

        //删除表尾元素
        list.remove(list.size() - 1);
        //删除索引信息
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}