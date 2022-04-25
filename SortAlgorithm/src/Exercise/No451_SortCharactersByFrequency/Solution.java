package Exercise.No451_SortCharactersByFrequency;

import java.util.*;

public class Solution {

    //方法一：自己实现桶排序
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }

        //以出现的频率构建桶
        List<Character>[] lists = new List[chars.length + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cFreq = entry.getValue();
            char aChar = entry.getKey();
            if (lists[cFreq] == null) {
                ArrayList<Character> arrayList = new ArrayList<>();
                arrayList.add(aChar);
                lists[cFreq] = arrayList;
            } else {
                lists[cFreq].add(aChar);
            }
        }

        StringBuilder ans = new StringBuilder("");
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                while (lists[i].size() > 0) {
                    char aChar = lists[i].remove(0);
                    for (int j = 0; j < i; j++) {
                        ans.append(aChar);
                    }
                }
            }
        }
        return String.valueOf(ans);
    }

    //方法二：答案实现桶排序
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int frequency = map.getOrDefault(aChar, 0) + 1;
            map.put(aChar, frequency);
            maxFreq = Math.max(frequency, maxFreq);
        }

        //创建一个桶
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }

        //对桶进行初始化
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char aChar = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(aChar);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            StringBuilder bucket = buckets[i];
            int length = bucket.length();
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    //方法三：按照出现频率排序
    public String frequencySort2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }

        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> (map.get(b) - map.get(a)));
        StringBuffer answer = new StringBuffer();
        for (Character character : list) {
            int frequency = map.get(character);
            for (int j = 0; j < frequency; j++) {
                answer.append(character);
            }
        }
        return answer.toString();
    }

    //方法四：Java自带API,优先队列+大根堆
    public String frequencySort3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue< >(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (Character character : map.keySet()) {
            queue.add(character);
        }

        StringBuilder ans = new StringBuilder();
        while (queue.size() > 0){
            char aChar = queue.remove();
            int frequency = map.get(aChar);
            for (int i = 0; i < frequency; i++){
                ans.append(aChar);
            }
        }
        return ans.toString();
    }
}