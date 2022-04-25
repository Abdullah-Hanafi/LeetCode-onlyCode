package Exercise.No380_InsertDeleteGetRandomO1;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/28 22:27
 */
public class RandomizedSet {
    //���key�����ݣ�value������
    private Map<Integer, Integer> map;

    //�������
    private List<Integer> list;
    //�����
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        //���hashmap��������ݵ���������ô����false
        if (map.containsKey(val)) return false;
        //û���������
        //�ȼ�¼����,����list.size()���ü�1
        map.put(val, list.size());
        //�嵽�����ĩβ
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        //û��Ҫɾ�������ݣ�ֱ�ӷ���false
        if (!map.containsKey(val)) return false;

        //�������һ�����ݺ�Ҫɾ�������ݵ�λ�ã�Ȼ������ĩβ��Ԫ��ɾ��
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        //����������Ϣ
        map.put(lastElement, index);

        //ɾ����βԪ��
        list.remove(list.size() - 1);
        //ɾ��������Ϣ
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}