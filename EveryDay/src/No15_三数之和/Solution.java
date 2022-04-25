package No15_����֮��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/12/2 10:32
 */
public class Solution {
    /**
     * ����
     * ��forѭ���̶���һ�����֣���˫ָ����ʣ�µ��������֣�����ʣ�µ��������ֺ��ǵ�һ�����ֵ��෴��
     * ��Ҫȥ�أ������ǹ̶��ĵ�һ�����֣������ظ�ֱ��������ǰѭ��������һ��ѭ�����磺-1,-1,-1,2
     * �����˫ָ��Ѱ����������ʱ������Ѿ��ҵ���num[left] + nums[right] == -��һ�����֣���ô����ֱ�ӽ���num[left]��num[right]��ͬ������ֱ��ȥ������
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //��������
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            //�̶���һ�����������һ����Ԫ��ĵ�һ�����͵�ǰ������һ��ֱ������
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    //�ҵ���
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //ȥ��nums[left]
                    int temp = nums[left];
                    while (nums[left] == temp && left < right) left++;

                    //ȥ��nums[right]
                    temp = nums[right];
                    while (nums[right] == temp && left < right) right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answer;
    }
}
