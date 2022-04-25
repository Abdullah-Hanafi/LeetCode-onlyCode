package Exercise.No763_PartitionLabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 方法一：贪心
     * 记录每个字母出现的最后的位置。
     * 记录当前片段开始的位置start和当前片段结束的位置end。
     * 遍历字符串，当访问到一个字符c时，其最后位置为endc，因为当前字符串结束的位置一定不小于endc，所以需要更新当前片段的结束位置为max(end,endc)
     * 当遍历到当前字符段结束位置时，进入下一个片段，更新start值。
     * 重复上述过程，直至遍历完字符串
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[] location = new int[26];   //记录26个英语小写字母的位置

        for (int i = 0; i < s.length(); i++) {
            location[s.charAt(i) - 'a'] = i;    //记录每个字母出现的最后的位置
        }

        int start = 0;  //当前片段开始的位置
        int end = 0;    //当前片段结束的位置
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, location[s.charAt(i) - 'a']);   //当前片段结束的位置为当前片段中所有字母出现的最后位置
            if (end == i) { //判断片段是否到达结束位置
                list.add(end - start + 1);
                start = end + 1;    //更新下一个片段的起始位置
            }
        }
        return list;
    }

}
