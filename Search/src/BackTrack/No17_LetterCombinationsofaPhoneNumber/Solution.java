package BackTrack.No17_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/20 17:35
 * ����˼·��
 * 1.��23Ϊ���Ȼ���һ�����ݵ���
 * 2.���������л����㷨��д
 * 3.�ݹ�һ�Σ�������������һ�㣬�ݹ���ڼ�����Ҷ�ӽڵ����һ��
 * 4.��ǰ�ڵ�ĺ�������Ϊforѭ����ѭ������
 * 5.forѭ���ڲ��������м�����洢������ٽ�����һ�㣬������
 */
public class Solution {
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        //��ʼ��map
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
     * @param current digits�ĵ�ǰ����λ��,Ҳ�ǵ�ǰ���Ĳ���
     * @param digits  �����digits
     * @param answer  ���ڱ������շ��ؽ���ı���
     * @param temp    ���ڱ����м���н�ı���
     */
    public void backtracking(int current, String digits, List<String> answer, StringBuffer temp) {
        //�ݹ����
        if (current == digits.length()) {
            answer.add(temp.toString());
            return;
        }

        //������ǰ�ڵ�
        char currentNode = digits.charAt(current);
        //��ǰ�ڵ��Ӧ���ַ�
        String str = map.get(currentNode);
        //��ǰ�ڵ�ĺ��ӽڵ�
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(current + 1, digits, answer, temp);
            temp.deleteCharAt(current);
        }
    }
}
