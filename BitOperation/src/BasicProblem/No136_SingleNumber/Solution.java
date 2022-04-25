package BasicProblem.No136_SingleNumber;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber5(nums));
    }

    //位运算
    public static int singleNumber(int[] nums) {
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            v ^= nums[i];
        }
        return v;
    }

    /**
     * 使用集合存储数字。
     * 遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合。
     * 如果集合中已经有该数字，则将该数字从集合中删除。
     * 最后剩下的数字就是只出现一次的数字。
     * HashSet实现
     */
    public static int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {    //如果元素不存在则可以add返回true，如果元素存在则add返回false
                set.remove(nums[i]);//元素已经存在，将元素移除
            }
        }
        return set.iterator().next();   //最后set里只有一个元素，就是所要求的元素
    }

    /**
     * 使用集合存储数字。
     * 遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合。
     * 如果集合中已经有该数字，则将该数字从集合中删除。
     * 最后剩下的数字就是只出现一次的数字。
     * TreeSet实现
     */

    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {    //如果元素不存在则可以add返回true，如果元素存在则add返回false
                set.remove(nums[i]);//元素已经存在，将元素移除
            }
        }
        return set.iterator().next();   //最后set里只有一个元素，就是所要求的元素
    }

    /**
     * 使用集合存储数字。
     * 遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合。
     * 如果集合中已经有该数字，则将该数字从集合中删除。
     * 最后剩下的数字就是只出现一次的数字。
     * ArrayList实现\LinkedList实现会超出时间限制
     */
    public static int singleNumber3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (nums[i] == list.get(j)) {
                    list.remove(j);
                    flag = true;
                }
            }
            if (!flag) {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    /**
     * 使用HashMap存储每个数字和该数字出现的次数
     * 遍历数组即可得到每个数字出现的次数，并更新哈希表。
     * 最后遍历哈希表，得到只出现一次的数字。
     */
    public static int singleNumber4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
            } else {
                map.put(nums[i], 1);
            }
        }

        int answer = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                answer = key;
            }
        }
        return answer;
    }

    /**
     * 使用集合存储数组中出现的所有数字，并计算数组中的元素之和。
     * 由于集合保证元素无重复，因此计算集合中的所有元素之和的两倍，即为每个元素出现两次的情况下的元素之和。
     * 由于数组中只有一个元素出现一次，其余元素都出现两次，因此用集合中的元素之和的两倍减去数组中的元素之和，剩下的数就是数组中只出现一次的数字。
     */
    public static int singleNumber5(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            set.add(nums[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            sum2 += iterator.next();
        }
        return 2 * sum2 - sum1;
    }

}
