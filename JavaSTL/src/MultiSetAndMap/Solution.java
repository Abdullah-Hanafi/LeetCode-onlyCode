package MultiSetAndMap;

import java.util.*;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/7 21:46
 */
public class Solution {
    //key为起点，value为终点，且终点是按照字典排序的
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    //结果是逆序的
    List<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);

            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }

            map.get(src).offer(dst);
        }

        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;

    }

    public void dfs(String current) {

        while (map.containsKey(current) && map.get(current).size() > 0) {
            String tmp = map.get(current).poll();
            dfs(tmp);
        }

        itinerary.add(current);
    }
}
