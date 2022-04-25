package Exercise.No870_AdvantageShuffle;

import java.util.*;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/12 9:43
 */
public class Solution {
    /**
     * 田忌赛马思想，nums1为田忌的马，nums2为齐王的马
     * 对nums1和nums2排序，如果nums1的马可以胜nums2的马，就分配；如果nums1的马不可以剩nums2的马，则拿来送人头用来比拼那些没有被分配的nums2的马
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] sort1 = nums1.clone();
        Arrays.sort(sort1);

        int[] sort2 = nums2.clone();
        Arrays.sort(sort2);

        Map<Integer, List<Integer>> assigned = new HashMap<>();
        //为齐王的每个马分配一个列表，用于记录能战胜齐王马的田忌马
        for (int i : nums2) {
            assigned.put(i, new LinkedList<>());
        }

        List<Integer> noAssigned = new LinkedList<>();

        int j = 0;
        for (int i : sort1) {
            if (i > sort2[j]) {
                //田忌的马强，就拿来和当前齐王的马打比赛
                assigned.get(sort2[j++]).add(i);
            } else {
                //田忌的马不行，因为已经排序了，所以这个田忌马不可能胜过剩下的任何一个齐王马，所以可以拿来送人头
                noAssigned.add(i);
            }
        }

        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            //当前齐王的马可以被战胜，分配一个田忌的马
            if (assigned.get(nums2[i]).size() > 0) {
                answer[i] = assigned.get(nums2[i]).remove(0);
            } else {
                //当前齐王的马不可以被战胜，分配一个田忌的送人头用的马
                answer[i] = noAssigned.remove(0);
            }
        }
        return answer;
    }
}
