package BackTrack.No17_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/20 17:35
 * 整体思路：
 * 1.以23为例先画出一个回溯的树
 * 2.根据树进行回溯算法书写
 * 3.递归一次，即进入树的下一层，递归出口即到了叶子节点的下一层
 * 4.当前节点的孩子数即为for循环的循环次数
 * 5.for循环内部，先用中间变量存储结果，再进入下一层，最后回溯
 */
public class Solution {
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        //初始化map
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> answer = new ArrayList<>();
        if (digits.length() == 0) {
            return answer;
        }
        StringBuffer temp = new StringBuffer();
        backtracking(0, digits, answer, temp);
        return answer;
    }

    /**
     * @param current digits的当前遍历位置,也是当前树的层数
     * @param digits  传入的digits
     * @param answer  用于保存最终返回结果的变量
     * @param temp    用于保存中间可行解的变量
     */
    public void backtracking(int current, String digits, List<String> answer, StringBuffer temp) {
        //递归出口
        if (current == digits.length()) {
            answer.add(temp.toString());
            return;
        }

        //分析当前节点
        char currentNode = digits.charAt(current);
        //当前节点对应的字符
        String str = map.get(currentNode);
        //当前节点的孩子节点
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(current + 1, digits, answer, temp);
            temp.deleteCharAt(current);
        }
    }
}
