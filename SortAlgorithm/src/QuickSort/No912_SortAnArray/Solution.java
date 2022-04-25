package QuickSort.No912_SortAnArray;

import java.util.Random;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/12 11:21
 */
public class Solution {
    public int[] sortArray(int[] nums) {

        randomizeQuicksort(nums, 0, nums.length - 1);

        return nums;
    }

    //�ݹ麯����ÿ���ҵ��ָ�㣬������һ��Ϊ���ݹ�
    public void randomizeQuicksort(int[] nums, int left, int right) {

        //�ݹ�������һֱ�ݹ鵽����ָ���غ�
        if (left < right) {

            //����һ�����򲢷��طָ��(������λ��)
            int partition = randomizePartition(nums, left, right);

            //�ݹ�ÿһ�������ָ�õ���������
            randomizeQuicksort(nums, left, partition - 1);
            randomizeQuicksort(nums, partition + 1, right);

        }
    }

    //1.�����ѡ������
    //2.��ѡ�������Ϊ��׼��Сֵ�������������м䣬��ʱ��ֵĬ�Ͼ��������ұ�
    //3.���ص�ǰ����λ�ã���Ϊ�ݹ麯���ķָ��
    public int randomizePartition(int[] nums, int left, int right) {

        //�����ѡ������λ��
        int pos = new Random().nextInt(right - left) + left;

        //����������ұ߽�
        swap(nums, pos, right);

        int pivot = nums[right];

        int patition = left;

        //�涨left��right�߽磬������ָ���ƶ�������partition
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, patition);
                ++patition;
            }
        }

        //����һ����������ֵ�������Ҷˣ�������м�
        swap(nums, patition, right);

        //���طָ��
        return patition;
    }

    //���Խ���Ԫ�ؽ����ĺ���
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}