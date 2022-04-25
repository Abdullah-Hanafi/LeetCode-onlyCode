package BackTrack.No77_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/14 11:45
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //�߽翼��
        if (n < k || k <= 0) {
            return null;
        }
        //���صĴ�
        List<List<Integer>> answer = new ArrayList<>();
        //ģ���������·��
        List<Integer> path = new ArrayList<>();
        //��ĿҪ���һ��������1
        int begin = 1;
        backTrack(n, k, begin, path, answer);
        return answer;
    }

    public void backTrack(int n, int k, int begin, List<Integer> path, List<List<Integer>> answer) {
        //���·�����ȵ���k��ʱ��ݹ����
        if (path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }

        //��ʼץ�Σ��ʼ��1��ʼץ
        for (int i = begin; i <= n; i++) {
            //ץ��ȥ
            path.add(i);

            //ץ��һ������
            backTrack(n, k, i + 1, path, answer);

            //״̬�ظ�
            path.remove(path.size() - 1);
        }

    }

}
