package BucketSort.No347_TopKFrequentElements;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //建立map，key是数组中的值，value是key在数组中出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果map中有key==nums[i]，则map.getOrDefault == map.get(nums[i])
            //如果map中没有key==nums[i]，则map.getOrDefault == 0
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //创建桶，桶的下标为桶中数字出现的频数，桶中的内容为相应的数字，如果不同的数字出现了相同的频数，则直接链接在桶中
        //假设nums中的所有数字是相同的，则该数字出现了num.length次，因此，应该将它放在nums.length号桶中
        //所以new的List的长度应该是nums.length+1
        List<Integer>[] lists = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            if (lists[count] == null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(num);
                lists[count] = arrayList;
            } else {
                lists[count].add(num);
            }
        }

        //从后往前遍历每个桶
        int[] result = new int[k];
        for (int i = lists.length - 1, count = 0; count < k; i--) {
            while (lists[i] != null && lists[i].size() > 0) {
                result[count++] = lists[i].remove(0);
            }
        }
        return result;
    }

}
